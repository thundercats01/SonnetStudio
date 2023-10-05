package com.example.lyricalapes.controllers;

import com.example.lyricalapes.models.User;
import com.example.lyricalapes.models.Verse;
import com.example.lyricalapes.repositories.CommentRepo;
import com.example.lyricalapes.repositories.UserRepo;
import com.example.lyricalapes.repositories.VerseRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProfileController {

    private UserRepo usersDAO;
    private VerseRepo verseRepo;
    private CommentRepo commentRepo;

    public ProfileController(UserRepo usersDAO, VerseRepo verseRepo, CommentRepo commentRepo) {
        this.usersDAO = usersDAO;
        this.verseRepo = verseRepo;
        this.commentRepo = commentRepo;
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        // Get the logged-in user
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = usersDAO.findByUsername(loggedInPrinciple.getUsername());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUsername = auth.getName();

        // Fetch posts made by the logged-in user in descending order by ID
        List<Verse> verses = verseRepo.findAllByUserOrderByIdDesc(loggedInUser);

        model.addAttribute("verses", verses);
        model.addAttribute("comments", commentRepo.findAll());
        model.addAttribute("username", loggedInUsername);
        model.addAttribute("bio",loggedInUser.getBio());
        model.addAttribute("currentBadge",loggedInUser.getCurrentBadge());

        return "profile/profileview";
    }



    @GetMapping("/profile/{id}")
    public String ShowOtherUserProfile(@PathVariable Long id, Model model) {
        User clickedUser = usersDAO.findById(id).get();
        model.addAttribute("user", clickedUser);
        return "profile/usersprofileview";
    }

    @PostMapping("/post_delete")
    public String RemoveSelectedPost(@RequestParam Long postid) {

        verseRepo.deleteById(postid);

        return "redirect:/profile";
    }

}
