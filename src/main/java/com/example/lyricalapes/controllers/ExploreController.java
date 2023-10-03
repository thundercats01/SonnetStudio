package com.example.lyricalapes.controllers;

import com.example.lyricalapes.models.Comment;
import com.example.lyricalapes.models.User;
import com.example.lyricalapes.repositories.CommentRepo;
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
public class ExploreController {

    private UserRepo usersDAO;
    private VerseRepo versesDAO;

    private CommentRepo CommentDAO;

    public ExploreController(UserRepo usersDAO, VerseRepo versesDAO, CommentRepo commentDAO) {
        this.usersDAO = usersDAO;
        this.versesDAO = versesDAO;
        this.CommentDAO = commentDAO;
    }

    @GetMapping("/explore")
    public String showExplorePage(Model model) {
        model.addAttribute("verses", versesDAO.findAll());

        return "explore";
    }

    @PostMapping("/explore")
    public String handleComments(@RequestParam Comment userComment) {
        Comment comment = new Comment();
        comment.setContent(String.valueOf(userComment));
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        comment.setUser(loggedInUser);
        CommentDAO.save(userComment);
        return "redirect:explore";
    }

}
