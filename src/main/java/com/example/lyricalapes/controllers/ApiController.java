package com.example.lyricalapes.controllers;

import com.example.lyricalapes.services.ApiKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiController {

   @Autowired
    private ApiKeys apiKeys;

    @GetMapping(value = "/keys.js", produces = "application/javascript")
    public String getKeys() {
        return String.format("""
                const spellCheckKey = "%s";
                const profanityCheckKey = "%s";
                """, apiKeys.getSpellCheck(), apiKeys.getProfanityCheck());
    }

}
