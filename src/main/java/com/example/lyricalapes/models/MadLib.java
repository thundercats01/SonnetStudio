package com.gptlibs.fullstackgptlibs.models;

import com.gptlibs.fullstackgptlibs.controllers.GptLibs;
import jakarta.persistence.*;

@Entity
public class MadLib {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "TEXT")
    private String story;
    @Column
    private String adj;
    @Column
    private String noun;
    @Column
    private String adv;
    @Column
    private String verb;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;


    public MadLib() {

    }


    public String getAdj() {
        return adj;
    }

    public String getNoun() {
        return noun;
    }

    public String getAdv() {
        return adv;
    }

    public String getVerb() {
        return verb;
    }

    public String getStory() {
        return story;
    }

    public void setStory() {
        this.story = GptLibs.genStory(this.noun, this.verb, this.adj, this.adv);
    }

    public void setAdj(String adj) {
        this.adj = adj;
    }

    public void setNoun(String noun) {
        this.noun = noun;
    }

    public void setAdv(String adv) {
        this.adv = adv;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}