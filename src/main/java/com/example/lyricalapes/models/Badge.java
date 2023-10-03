package com.example.lyricalapes.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "badges")
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String path = "";
    @ManyToMany(mappedBy = "badges", cascade = CascadeType.PERSIST)
    private List<User> users;

    ///////CONSTRUCTORS ////////
    public Badge() {
    }

    public Badge(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Badge(long id, String name, String description, List<User> users) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.users = users;
    }

    public Badge(long id, String name, String description, String path, List<User> users) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.path = path;
        this.users = users;
    }

    //////GETTER & SETTER//////
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
