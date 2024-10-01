package com.codehex.blog.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * A classe representa o um post do blog
 * Armazena informaçções como titulo,autor,descriçção, o link da imagem e a
 * data em que o post foi criado.
 * Cada blog tem um identificador único.
 */
@Entity
@Table(name = "blog")
public class BlogEntity {

    /**
     * O ID único de cada post de blog, gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * O título do post do blog, que descreve sobre o que é o conteúdo.
     */
    @Column(name = "titulo")
    private String title;
    /**
     * O nome do autor escreveu o post.
     */
    @Column(name = "autor")
    private String actor;

    /**
     * Uma descrição do post, fornecer mais detalhes sobre o conteúdo.
     */
    @Column(name = "descricao")
    private String description;

    /**
     * Um link para imagem associada ao post.
     */
    @Column(name = "imagem_link")
    private String urlimage;

    /**
     * A data e hora em que o post foi criado.
     * Esse campo é preenchido automaticamente assim que o post é salvo.
     */
    @Column(name = "data_criacao")
    private LocalDateTime dateCreatetion;

    /**
     * Antes de o post ser salvo no banco de dados, este método define automaticamente
     * a data de criação para o momento atual.
     */
    @PrePersist
    private void DateCrete() {
        this.dateCreatetion = LocalDateTime.now();
    }

    // Métodos getter e setter para acessar e modificar os dados do post

    /**
     * Obtém o ID do post.
     *
     * @return O ID do post.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do post.
     *
     * @param id O ID a ser definido.
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getUrlimage() {
        return urlimage;
    }

    public void setUrlimage(String urlimage) {
        this.urlimage = urlimage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateCreatetion() {
        return dateCreatetion;
    }

    public void setDateCreatetion(LocalDateTime dateCreatetion) {
        this.dateCreatetion = dateCreatetion;
    }
}
