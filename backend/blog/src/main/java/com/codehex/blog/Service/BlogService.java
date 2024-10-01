package com.codehex.blog.Service;

import com.codehex.blog.Entity.BlogEntity;
import com.codehex.blog.Repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * O serviço para gerenciar operações relacionadas a blogs.
 * O serviço contém a lógica de negócio e interage com o repositório
 * BlogRepository para acessar e manipular dados do blogs.
 */
@Service
public class BlogService {

    // Atributo que representa o repository do blog
    private final BlogRepository blogRepository;

    /**
     * Injeção de dependência via construtor.
     *
     * @param blogRepository O repositório de postagens de blog.
     */
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    /**
     * Cria uma nova postagem de blog e a salva no repositório.
     *
     * @param blogEntity A entidade da postagem a ser criada.
     * @return A entidade da postagem criada.
     */
    public BlogEntity createPost(BlogEntity blogEntity) {
        return blogRepository.save(blogEntity);
    }

    /**
     * Recupera todas as postagens de blog existentes.
     *
     * @return Uma lista de entidades de postagens de blog.
     */
    public List<BlogEntity> getPosts() {
        return blogRepository.findAll();
    }

    /**
     * Recupera uma postagem do blog específicada pelo o ID.
     *
     * @param id O Identificador da postagem a ser recuperada.
     * @return A entidade da postagem correspondente ou null não encontre.
     */

    public BlogEntity getPostById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    /**
     * Atualiza uma postagem do blog existente.
     *
     * @param id         O identificador da postagem.
     * @param blogEntity A entidade da postagem contendo os novos dados.
     * @return A enteidade da postaggem atualizada  ou null se não encontrada.
     */
    public BlogEntity updatePost(Long id, BlogEntity blogEntity) {
        Optional<BlogEntity> optionalBlogEntity = blogRepository.findById(id);
        if (optionalBlogEntity.isPresent()) {
            BlogEntity existingBlog = optionalBlogEntity.get();
            existingBlog.setTitle(blogEntity.getTitle());
            existingBlog.setDescription(blogEntity.getDescription());
            existingBlog.setUrlimage(blogEntity.getUrlimage());
            existingBlog.setActor(blogEntity.getActor());
            return blogRepository.save(existingBlog);
        }
        return null;
    }

    /**
     * Deleta uma postagem de Blog existente pelo identificador.
     *
     * @param id O Identificador da postagem a ser deletado.
     * @return true se a postagem foi deletada com sucesso, false caso contrário.
     */
    public boolean deletePost(Long id) {
        if (blogRepository.existsById(id)) {
            blogRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
