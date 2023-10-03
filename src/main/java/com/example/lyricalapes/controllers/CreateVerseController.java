package com.example.lyricalapes.controllers;

import com.example.lyricalapes.models.User;
import com.example.lyricalapes.models.Verse;
import com.example.lyricalapes.repositories.UserRepo;
import com.example.lyricalapes.repositories.VerseRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class CreateVerseController {

    private UserRepo usersDAO;
    private VerseRepo versesDAO;

    public CreateVerseController(UserRepo usersDAO, VerseRepo versesDAO) {
        this.usersDAO = usersDAO;
        this.versesDAO = versesDAO;
    }

    @GetMapping("/create")
    public String showProfile() {
        return "profile/createverse";
    }

    //    @PostMapping()
    // user can actually create a post and it get saved to the database
    @PostMapping("/create")
    public String getVerseParams(@RequestParam String verseText) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        Verse verse = new Verse();
        verse.setUser(loggedInUser);
        verse.setContent(verseText);

        versesDAO.save(verse);
        return "redirect:/profile";

    }


}
