package com.codehex.blog.Repository;

import com.codehex.blog.Entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Este repository gerencia as operações de acesso ao banco de dados para a entidade Blog.
 * Ele estende o JpaRepository, o que significa que já fornece métodos prontos para
 * realizar operações como salvar, buscar, atualizar e deletar posts de blog no banco de dados.
 *
 * Não é necessário escrever código para as operações básicas de CRUD,
 * pois o JpaRepository já cuida de tudo.
 * Basta usar essa interface no serviço para manipular os posts de blog diretamente no banco de dados.
 */
@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long> {

}
