package com.example.lyricalapes.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    @Column
    private String password;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    private List<Verse> verses;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "user_badges",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "badges_id")}
    )
    private List<Badge> badges;
    @ManyToMany(mappedBy = "following", cascade = CascadeType.PERSIST)
    private List<User> followers;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "followers",
            joinColumns = {@JoinColumn(name = "followers_user_id")},
            inverseJoinColumns = {@JoinColumn(name = "following_user_id")}
    )
    private List<User> following;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Comment> comments;

    @Column
    private String bio;

    @Column
    private int likesCount;

    @Column
    private int pointsCount;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Like> likes;

    ///////CONSTRUCTORS ////////


    public User(User copy) {
        this.id = copy.id;
        this.email = copy.email;
        this.username = copy.username;
        this.password = copy.password;
    }

    public User(long id, String username, String email, String password, List<Verse> verses, List<Badge> badges) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.verses = verses;
        this.badges = badges;
    }

    public User(long id, String username, String email, String password, List<Verse> verses, List<Badge> badges, List<User> followers, List<User> following, List<Comment> comments, String bio, int likesCount, int pointsCount) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.verses = verses;
        this.badges = badges;
        this.followers = followers;
        this.following = following;
        this.comments = comments;
        this.bio = bio;
        this.likesCount = likesCount;
        this.pointsCount = pointsCount;
    }

    public User() {

    }

    //////GETTER & SETTER//////


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Verse> getVerses() {
        return verses;
    }

    public void setVerses(List<Verse> verses) {
        this.verses = verses;
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getPointsCount() {
        return pointsCount;
    }

    public void setPointsCount(int pointsCount) {
        this.pointsCount = pointsCount;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}