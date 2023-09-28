package com.example.lyricalapes.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "verses")
public class Verse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String title;


    @Column(columnDefinition = "TEXT")
    private String Content;

    @Column
    private String genre;
    ///////CONSTRUCTORS ////////

    public Verse() {

    }

    public Verse(long id, User user, String title, String content, String genre, List<Comment> comments, List<Like> likes) {
        this.id = id;
        this.user = user;
        this.title = title;
        Content = content;
        this.genre = genre;
        this.comments = comments;
        this.likes = likes;
    }

    @OneToMany(mappedBy = "verse", cascade = CascadeType.PERSIST)
    private List<Comment> comments;

    @OneToMany(mappedBy = "verse", cascade = CascadeType.PERSIST)
    private List<Like> likes;
    //////GETTER & SETTER//////
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }
}