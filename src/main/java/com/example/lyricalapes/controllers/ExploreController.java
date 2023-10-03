package com.example.lyricalapes.controllers;

import com.example.lyricalapes.models.User;
import com.example.lyricalapes.repositories.UserRepo;
import com.example.lyricalapes.repositories.VerseRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ExploreController {

    private UserRepo usersDAO;
    private VerseRepo versesDAO;

    public ExploreController(UserRepo usersDAO, VerseRepo versesDAO) {
        this.usersDAO = usersDAO;
        this.versesDAO = versesDAO;
    }

    @GetMapping("/explore")
    public String showExplorePage(Model model) {
        model.addAttribute("verses", versesDAO.findAll());

        return "explore";
    }


}
