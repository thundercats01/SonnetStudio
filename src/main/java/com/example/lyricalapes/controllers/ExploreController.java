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

    private CommentRepo commentDAO;

    public ExploreController(UserRepo usersDAO, VerseRepo versesDAO, CommentRepo commentDAO) {
        this.usersDAO = usersDAO;
        this.versesDAO = versesDAO;
        this.commentDAO = commentDAO;
    }

    @GetMapping("/explore")
    public String showExplorePage(Model model) {
        model.addAttribute("verses", versesDAO.findAll());
        model.addAttribute("comments", commentDAO.findAll());

        return "explore";
    }

    @PostMapping("/explore")
    public String handleComments(@RequestParam String userComment, @RequestParam Long postid) {
        Comment comment = new Comment();
        comment.setContent(userComment);
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        comment.setVerse();
        comment.setUser(loggedInUser);
        commentDAO.save(comment);
//        System.out.println("blank");
        return "explore";
    }

}
