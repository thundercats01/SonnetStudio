package com.example.lyricalapes.controllers;

import com.example.lyricalapes.models.Comment;
import com.example.lyricalapes.models.Like;
import com.example.lyricalapes.models.User;
import com.example.lyricalapes.models.Verse;
import com.example.lyricalapes.repositories.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class BadgePageController {
    private UserRepo userDao;
    private BadgeRepo badgesDao;
    private LikeRepo likesDao;
    private VerseRepo versesDao;
    private CommentRepo commentDao;

    public BadgePageController(UserRepo userDao, BadgeRepo badgesDao, LikeRepo likesDao, VerseRepo versesDao, CommentRepo commentDao) {
        this.userDao = userDao;
        this.badgesDao = badgesDao;
        this.likesDao = likesDao;
        this.versesDao = versesDao;
        this.commentDao = commentDao;
    }

    @GetMapping("/badge")
    public String showBadgePage(Model model) {
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = userDao.findByUsername(loggedInPrinciple.getUsername());
//        User user = userDao.findById(loggedInUser.getId()).get();
        List<Comment> commentsPerVerse = new ArrayList<>();
        for (Verse verse : loggedInUser.getVerses()) {
            for (Comment comment : verse.getComments()) {
                commentsPerVerse.add(comment);
            }
        }
        long totalLikesOfLoggedinUser = 0;
        for(Verse verse : loggedInUser.getVerses()) {
            List<Like> likesForThisVerse = likesDao.findAllByVerse(verse);
            System.out.println(likesForThisVerse);
            totalLikesOfLoggedinUser += likesForThisVerse.size();
        }
        model.addAttribute("totalCommentsOfLoggedInUser", commentsPerVerse.size());
        model.addAttribute("totalFollowersOfLoggedInUser", loggedInUser.getFollowing().size());
        model.addAttribute("totalFollowingOfLoggedInUser", loggedInUser.getFollowers().size());
        model.addAttribute("totalLikesOfLoggedInUser",totalLikesOfLoggedinUser);

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
