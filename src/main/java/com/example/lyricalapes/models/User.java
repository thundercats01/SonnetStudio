package com.gptlibs.fullstackgptlibs.models;

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
    private List<MadLib> madLibs;

    public User() {
    }

    public User(User copy) {
        id = copy.id;
        email = copy.email;
        username = copy.username;
        password = copy.password;
        madLibs = copy.madLibs;
    }

    public User(long id, String username, String email, String password, List<MadLib> madLibs) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.madLibs = madLibs;
    }

    public User(String username, String email, String password, List<MadLib> madLibs) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.madLibs = madLibs;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

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

    public List<MadLib> getMadLibs() {
        return madLibs;
    }

    public void setMadLibs(List<MadLib> madLibs) {
        this.madLibs = madLibs;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}