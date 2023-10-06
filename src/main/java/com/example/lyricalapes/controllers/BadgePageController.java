package com.example.lyricalapes.controllers;

import com.example.lyricalapes.models.Like;
import com.example.lyricalapes.models.User;
import com.example.lyricalapes.models.Verse;
import com.example.lyricalapes.repositories.BadgeRepo;
import com.example.lyricalapes.repositories.LikeRepo;
import com.example.lyricalapes.repositories.UserRepo;
import com.example.lyricalapes.repositories.VerseRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class BadgePageController {
    private UserRepo userDao;
    private BadgeRepo badgesDao;
    private LikeRepo likesDao;
    private VerseRepo versesDao;

    public BadgePageController(UserRepo userDao, BadgeRepo badgesDao, LikeRepo likesDao, VerseRepo versesDao) {
        this.userDao = userDao;
        this.badgesDao = badgesDao;
        this.likesDao = likesDao;
        this.versesDao = versesDao;
    }

    @GetMapping("/badge")
    public String showBadgePage(Model model) {
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = userDao.findByUsername(loggedInPrinciple.getUsername());
//        User user = userDao.findById(loggedInUser.getId()).get();
        long totalLikesOfLoggedinUser = 0;
        for(Verse verse : loggedInUser.getVerses()) {
            List<Like> likesForThisVerse = likesDao.findAllByVerse(verse);
            System.out.println(likesForThisVerse);
            totalLikesOfLoggedinUser += likesForThisVerse.size();
        }
        model.addAttribute("likes",totalLikesOfLoggedinUser);

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
