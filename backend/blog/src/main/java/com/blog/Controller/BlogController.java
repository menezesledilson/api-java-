package com.blog.Controller;

import com.blog.Entity.BlogEntity;
import com.blog.Service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller REST para gerenciar operações relacionadas a postagem.
 * O controller  expõe endpoints para criar, ler, atualizar e deletar as postagem
 * Através de uma API RESTful. Ele interage com a camada de serviço BlogService
 * para realizar as operações necessárias.
 */
// Indica que esta classe é um controlador REST
@RestController
// Mapeia requisições para a URL base "/blog"
@RequestMapping("/artigo")
// Permite requisições de qualquer origem
@CrossOrigin(origins = "*")
public class BlogController {

    // Atributo que representa o serviço de blog
    private final BlogService blogService;

    /**
     * Injeção de dependência via construtor.
     * @param blogService O serviço de postagens de blog.
     */
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    /**
     * @param blogEntity A entidade da postagem a ser criada.
     * @return Um ResponseEntity contem uma mapa com o resultado da operação.
     */

    @PostMapping("/criar")
    public ResponseEntity<Map<String, Object>> createArticle(@RequestBody BlogEntity blogEntity) {
        BlogEntity createPost = blogService.createArticle(blogEntity);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("post", createPost);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/listar")
    public List<BlogEntity> getArticleAll(){
        return blogService.getArticleAll();
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<BlogEntity>getArticleById(@PathVariable Long id){
        BlogEntity blogEntity = blogService.getArticleById(id);
        if(blogEntity != null){
            return  ResponseEntity.ok(blogEntity);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<BlogEntity>>getArticleByCategory(@PathVariable String category){
        List<BlogEntity> blogEntity = blogService.getArticleByCategory(category);
        if(blogEntity != null){
            return  ResponseEntity.ok(blogEntity);
        }else {
            return  ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updatedArticle(@PathVariable Long id, @RequestBody BlogEntity blogEntity) {
        BlogEntity updatedArticle = blogService.updatedArticle(id, blogEntity);
        Map<String, Object> responseUpdate = new HashMap<>();

        if (updatedArticle != null) {
            responseUpdate.put("success", true);
            responseUpdate.put("post", updatedArticle);
            return ResponseEntity.ok(responseUpdate);
        } else {
            responseUpdate.put("success", false);
            responseUpdate.put("message", "Blog post not found");
            return ResponseEntity.status(404).body(responseUpdate);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
        boolean delete = blogService.deleteArticle(id);
        if(delete){
            return ResponseEntity.noContent().build();

        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
