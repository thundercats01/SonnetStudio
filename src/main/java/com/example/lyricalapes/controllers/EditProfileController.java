package com.example.lyricalapes.controllers;

import com.example.lyricalapes.models.User;
import com.example.lyricalapes.repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class EditProfileController {
    private UserRepo userRepo;

    public EditProfileController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @GetMapping("/edit-profile")
    public String showEditProfile(Model model) {
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = userRepo.findByUsername(loggedInPrinciple.getUsername());
        model.addAttribute("user", loggedInUser);

        return "profile/editprofile";

    }

    @PostMapping("/edit-profile")
    public String editUserProfile(@RequestParam String username, @RequestParam String email, @RequestParam String bio) {

        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = userRepo.findByUsername(loggedInPrinciple.getUsername());
        User userToUpdate = userRepo.findById(loggedInUser.getId()).get();

        userToUpdate.setUsername(username);
        userToUpdate.setEmail(email);
        userToUpdate.setBio(bio);
        userRepo.save(userToUpdate);
        return "redirect:/profile";
    }

//    @PostMapping("/edit-profile")
//    public String editUserProfile(@ModelAttribute User user) {
//        User userToUpdate = userRepo.findById(user.getId()).orElse(null);
//        userToUpdate.setUsername(user.getUsername());
//        userToUpdate.setPassword(user.getPassword());
//        userToUpdate.setEmail(user.getEmail());
//        userToUpdate.setBio(user.getBio());
//        userRepo.save(userToUpdate);
//
//
//        return "redirect:/profile";
//    }
}
