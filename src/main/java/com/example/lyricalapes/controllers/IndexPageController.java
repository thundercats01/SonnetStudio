package com.example.lyricalapes.controllers;

import com.example.lyricalapes.models.User;
import com.example.lyricalapes.repositories.UserRepo;
import com.example.lyricalapes.repositories.VerseRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class IndexPageController {

    VerseRepo versesDAO;
    UserRepo usersDAO;

    public IndexPageController(VerseRepo versesDAO, UserRepo usersDAO) {
        this.versesDAO = versesDAO;
        this.usersDAO = usersDAO;
    }

    @GetMapping
    public String showLandingPage() {
        return "index";
    }

    @GetMapping("/show")
    public String showHomePage(Model model) {
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = usersDAO.findByUsername(loggedInPrinciple.getUsername());

        model.addAttribute("stories", versesDAO.findAllByUser(loggedInUser));
        return "explore-page";
    }

    @PostMapping
    public String getMadLibParams(@RequestParam String adj, @RequestParam String adv, @RequestParam String noun, @RequestParam String verb) {
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = usersDAO.findByUsername(loggedInPrinciple.getUsername());

        return "redirect:/play/show";

    }
}
