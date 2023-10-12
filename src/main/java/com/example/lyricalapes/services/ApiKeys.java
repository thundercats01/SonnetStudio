package com.example.lyricalapes.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class ApiKeys {

    @Value("${spell.check}")
    private String spellCheck;

    @Value("${profanity.check}")
    private String profanityCheck;

    public String getSpellCheck() {
        return spellCheck;
    }

    public void setSpellCheck(String spellCheck) {
        this.spellCheck = spellCheck;
    }

    public String getProfanityCheck() {
        return profanityCheck;
    }

    public void setProfanityCheck(String profanityCheck) {
        this.profanityCheck = profanityCheck;
    }
}
