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
        String badgePath = "/capstone_IMGs/badges/badge-apple.jpeg";
        userToUpdate.setCurrentBadge(badgePath);
        userDao.save(userToUpdate);
        return "redirect:/profile";
    }

    @PostMapping("/default-badge")
    public String defaultBadge() {
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = userDao.findByUsername(loggedInPrinciple.getUsername());
        User userToUpdate = userDao.findById(loggedInUser.getId()).get();
        String badgePath = "/capstone_IMGs/badges/badge-default.png";
        userToUpdate.setCurrentBadge(badgePath);
        userDao.save(userToUpdate);
        return "redirect:/profile";
    }

    @PostMapping("/einstein-badge")
    public String einsteinBadge() {
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = userDao.findByUsername(loggedInPrinciple.getUsername());
        User userToUpdate = userDao.findById(loggedInUser.getId()).get();
        String badgePath = "/capstone_IMGs/badges/badge-einstein.jpeg";
        userToUpdate.setCurrentBadge(badgePath);
        userDao.save(userToUpdate);
        return "redirect:/profile";
    }

    @PostMapping("/joan-badge")
    public String joanBadge() {
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = userDao.findByUsername(loggedInPrinciple.getUsername());
        User userToUpdate = userDao.findById(loggedInUser.getId()).get();
        String badgePath = "/capstone_IMGs/badges/badge-joan.jpeg";
        userToUpdate.setCurrentBadge(badgePath);
        userDao.save(userToUpdate);
        return "redirect:/profile";
    }

    @PostMapping("/king-badge")
    public String kingBadge() {
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = userDao.findByUsername(loggedInPrinciple.getUsername());
        User userToUpdate = userDao.findById(loggedInUser.getId()).get();
        String badgePath = "/capstone_IMGs/badges/badge-king.webp";
        userToUpdate.setCurrentBadge(badgePath);
        userDao.save(userToUpdate);
        return "redirect:/profile";
    }

    @PostMapping("/masterkey-badge")
    public String masterkeyBadge() {
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = userDao.findByUsername(loggedInPrinciple.getUsername());
        User userToUpdate = userDao.findById(loggedInUser.getId()).get();
        String badgePath = "/capstone_IMGs/badges/badge-masterkey.jpeg";
        userToUpdate.setCurrentBadge(badgePath);
        userDao.save(userToUpdate);
        return "redirect:/profile";
    }

    @PostMapping("/pearl-badge")
    public String pearlBadge() {
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = userDao.findByUsername(loggedInPrinciple.getUsername());
        User userToUpdate = userDao.findById(loggedInUser.getId()).get();
        String badgePath = "/capstone_IMGs/badges/badge-pearl.avif";
        userToUpdate.setCurrentBadge(badgePath);
        userDao.save(userToUpdate);
        return "redirect:/profile";
    }

    @PostMapping("/socrates-badge")
    public String socratesBadge() {
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = userDao.findByUsername(loggedInPrinciple.getUsername());
        User userToUpdate = userDao.findById(loggedInUser.getId()).get();
        String badgePath = "/capstone_IMGs/badges/badge-socrates.jpeg";
        userToUpdate.setCurrentBadge(badgePath);
        userDao.save(userToUpdate);
        return "redirect:/profile";
    }
}
