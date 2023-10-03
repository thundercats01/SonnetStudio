package com.example.lyricalapes.controllers;

import com.example.lyricalapes.models.User;
import com.example.lyricalapes.repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EditProfileController {
    private UserRepo userRepo;

    public EditProfileController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @GetMapping("edit-profile")
    public String showEditProfile(Model model) {
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = userRepo.findByUsername(loggedInPrinciple.getUsername());
        model.addAttribute("user", loggedInUser);

        return "profile/editprofile";

    }

}
