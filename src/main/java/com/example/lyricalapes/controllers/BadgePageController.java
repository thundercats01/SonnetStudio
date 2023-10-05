package com.example.lyricalapes.controllers;

import com.example.lyricalapes.models.User;
import com.example.lyricalapes.repositories.BadgeRepo;
import com.example.lyricalapes.repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BadgePageController {
    private UserRepo userDao;
    private BadgeRepo BadgesDao;

    public BadgePageController(UserRepo userDao, BadgeRepo badgesDao) {
        this.userDao = userDao;
        BadgesDao = badgesDao;
    }

    @GetMapping("/badge")
    public String showBadgePage() {
        return "profile/badge";
    }


    @PostMapping("/apple-badge")
    public String appleBadge() {
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = userDao.findByUsername(loggedInPrinciple.getUsername());
        User userToUpdate = userDao.findById(loggedInUser.getId()).get();
        String apple = "/capstone_IMGs/badges/badge-apple.jpeg";
        userToUpdate.setCurrentBadge(apple);
        userDao.save(userToUpdate);
        return "redirect:/profile";
    }


}
