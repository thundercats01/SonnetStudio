package com.example.lyricalapes.controllers;

import com.example.lyricalapes.models.User;
import com.example.lyricalapes.repositories.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ProfileController {

    private UserRepo usersDAO;


    public ProfileController(UserRepo usersDAO) {
        this.usersDAO = usersDAO;
    }

    @GetMapping("/profile")
    public String showProfile() {
        return "profile/profileview";
    }

    @GetMapping("/profile/{id}")
    public String ShowOtherUserProfile(@PathVariable Long id, Model model) {
        User clickedUser = usersDAO.findById(id).get();
        model.addAttribute("user",clickedUser);
        return "profile/usersprofileview";
    }

}
