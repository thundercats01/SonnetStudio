package com.example.lyricalapes.controllers;

import com.example.lyricalapes.repositories.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ExploreController {

    private UserRepo usersDAO;
    private PasswordEncoder passwordEncoder;

    public ExploreController(UserRepo usersDAO, PasswordEncoder passwordEncoder) {
        this.usersDAO = usersDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/explore")
    public String showExplorePage() {
        return "explore";
    }


}
