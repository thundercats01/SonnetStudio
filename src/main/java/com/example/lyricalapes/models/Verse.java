package com.example.lyricalapes.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "verses")
public class Verse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;


    @Column(columnDefinition = "TEXT")
    private String Content;

    @Column
    private String genre;

    @OneToMany(mappedBy = "verse", cascade = CascadeType.ALL)
    private List<Comment> comments;

  @OneToMany(mappedBy = "verse", cascade = CascadeType.ALL)
  private List<Like> likes;
    ///////CONSTRUCTORS ////////

    public Verse() {

    }

    public Verse(long id, User user, String title, String content, String genre, List<Comment> comments, List<Like> likes) {
        this.id = id;
        this.user = user;
        this.Content = content;
        this.genre = genre;
        this.comments = comments;
        this.likes = likes;
    }


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