package com.example.lyricalapes.controllers;

import com.example.lyricalapes.repositories.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CreateVerseController {

    UserRepo usersDAO;

    public CreateVerseController(UserRepo usersDAO) {
        this.usersDAO = usersDAO;
    }

    @GetMapping("/create")
    public String showProfile() {
        return "profile/createverse";
    }

//    @PostMapping()
    // user can actually create a post and it get saved to the database

}
