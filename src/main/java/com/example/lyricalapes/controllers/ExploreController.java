package com.example.lyricalapes.controllers;

import com.example.lyricalapes.models.Comment;
import com.example.lyricalapes.models.Like;
import com.example.lyricalapes.models.User;
import com.example.lyricalapes.models.Verse;
import com.example.lyricalapes.repositories.CommentRepo;
import com.example.lyricalapes.repositories.LikeRepo;
import com.example.lyricalapes.repositories.UserRepo;
import com.example.lyricalapes.repositories.VerseRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
//@RequestMapping("/")
public class ExploreController {

    private UserRepo usersDAO;
    private VerseRepo versesDAO;
    private LikeRepo likesDAO;
    private CommentRepo commentDAO;

    public ExploreController(UserRepo usersDAO, VerseRepo versesDAO, LikeRepo likesDAO, CommentRepo commentDAO) {
        this.usersDAO = usersDAO;
        this.versesDAO = versesDAO;
        this.likesDAO = likesDAO;
        this.commentDAO = commentDAO;
    }

    @GetMapping("/explore")
    public String showExplorePage(Model model) {
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = usersDAO.findByUsername(loggedInPrinciple.getUsername());
        List<Verse> allVersesInDescOrder = versesDAO.findAllByOrderByIdDesc();



        model.addAttribute("verses", allVersesInDescOrder);
        List<Comment> allComments = commentDAO.findAll();
        model.addAttribute("comments", commentDAO.findAll());


//        Map<Verse, Long> commentCounts = allComments.stream()
//                .collect(Collectors.groupingBy(Comment::getVerse, Collectors.counting()));
//        model.addAttribute("commentCounts", commentCounts);


        return "explore";
    }

//    @GetMapping("/explore")
//    public String showExplorePage(Model model) {
//        List<Verse> allVersesInDescOrder = versesDAO.findAllByOrderByIdDesc();
//        model.addAttribute("verses", allVersesInDescOrder);
//        model.addAttribute("comments", commentDAO.findAll());
//
//        return "explore";
//    }

    @PostMapping("/explore")
    public String handleComments(@RequestParam String userComment, @RequestParam Long verseId) {
        Comment comment = new Comment();
        comment.setContent(userComment);
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = usersDAO.findByUsername(loggedInPrinciple.getUsername());
        comment.setVerse(versesDAO.findById(verseId).get());
        comment.setUser(loggedInUser);
        commentDAO.save(comment);
//        System.out.println("blank");
        return "redirect:explore";
    }

    @PostMapping("/like")
    public String handleLikes(@RequestParam("verse-id") Long verseId) {
        System.out.println("inside handleLikes");
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = usersDAO.findByUsername(loggedInPrinciple.getUsername());
        // get user id
        Like like = new Like();
        // get verse id
        // set them to like object
        like.setUser(loggedInUser);
        like.setVerse(versesDAO.findById(verseId).get());
        if(!likesDAO.existsByUserAndVerse(like.getUser(), like.getVerse())) {
            // save to likes table
            likesDAO.save(like);
        }

        System.out.println("blank");
        return "redirect:explore";
    }


}
