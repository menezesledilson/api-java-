package com.codehex.blog.Controller;

import com.codehex.blog.Entity.BlogEntity;
import com.codehex.blog.Service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
@RequestMapping("/blog")
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

    @PostMapping("/post")
    public ResponseEntity<Map<String, Object>> createPost(@RequestBody BlogEntity blogEntity) {
        BlogEntity createPost = blogService.createPost(blogEntity);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("post", createPost);
        return ResponseEntity.ok(response);
    }

    //Criar endpoint GET, GET por id, PUT,DELETE
}
