package com.example.lyricalapes.controllers;

import com.example.lyricalapes.models.Comment;
import com.example.lyricalapes.models.Like;
import com.example.lyricalapes.models.User;
import com.example.lyricalapes.models.Verse;
import com.example.lyricalapes.repositories.CommentRepo;
import com.example.lyricalapes.repositories.LikeRepo;
import com.example.lyricalapes.repositories.UserRepo;
import com.example.lyricalapes.repositories.VerseRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        model.addAttribute("pageTitle", "Explore Page");


//        Map<Verse, Long> commentCounts = allComments.stream()
//                .collect(Collectors.groupingBy(Comment::getVerse, Collectors.counting()));
//        model.addAttribute("commentCounts", commentCounts);


        return "explore";
    }

//    @GetMapping("/explore")  THIS IS OLD CODE
//    public String showExplorePage(Model model) {
//        List<Verse> allVersesInDescOrder = versesDAO.findAllByOrderByIdDesc();
//        model.addAttribute("verses", allVersesInDescOrder);
//        model.addAttribute("comments", commentDAO.findAll());
//
//        return "explore";
//    }

    @PostMapping("/explore")
    public String handleComments(@RequestParam String userComment,
                                 @RequestParam Long verseId,
                                 @RequestParam(name = "currentProfileUrl", required = false) String profileUrl) {
        Comment comment = new Comment();
        comment.setContent(userComment);
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = usersDAO.findByUsername(loggedInPrinciple.getUsername());
        comment.setVerse(versesDAO.findById(verseId).get());
        comment.setUser(loggedInUser);
        commentDAO.save(comment);

        if (profileUrl != null && !profileUrl.trim().isEmpty()) {
            return "redirect:" + profileUrl;  // Redirect to the profile page where the comment was added.
        } else {
            return "redirect:explore";  // Default redirection to the explore page.
        }
    }


    @PostMapping("/like/")
    public String handleLikesFromExplorePage(@RequestParam("verse-id") Long verseId) {
        System.out.println("inside handleLikes");
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = usersDAO.findByUsername(loggedInPrinciple.getUsername());
        // get user id
        Like like = new Like();
        // get verse id
        // set them to like object
        like.setUser(loggedInUser);
        Verse likedVerse = versesDAO.findById(verseId).get();
        Long userId =likedVerse.getUser().getId();
        like.setVerse(likedVerse);

        if (!likesDAO.existsByUserAndVerse(like.getUser(), like.getVerse())) {
            // save to likes table
            likesDAO.save(like);
        }
        System.out.println("blank");
        return "redirect:explore";
    }

    @PostMapping("/like")
    public String handleLikesOnOtherUsersProfilePage(@RequestParam("verse-id") Long verseId,
                                                     HttpServletRequest request) {
        System.out.println("inside handleLikes");
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = usersDAO.findByUsername(loggedInPrinciple.getUsername());

        // get user id
        Like like = new Like();
        // get verse id
        // set them to like object
        like.setUser(loggedInUser);
        Verse likedVerse = versesDAO.findById(verseId).get();
        Long userId =likedVerse.getUser().getId();
        like.setVerse(likedVerse);
        if (!likesDAO.existsByUserAndVerse(like.getUser(), like.getVerse())) {
            // save to likes table
            likesDAO.save(like);
        }

        System.out.println("blank");
        String referer = request.getHeader("Referer");
        System.out.println("This is the REFERER" + referer);
        if (referer.contains("explore")) {
        return "redirect:explore";
        } else {
            return "redirect:profile/" +userId;
        }
    }

    //    For Search of userNames
    @GetMapping("/searchUsers")
    @ResponseBody
    public List<User> searchUsers(@RequestParam("query") String search) {
        System.out.println("inside searchUsers");
        System.out.println(search);
        return usersDAO.findByUsernameContainingIgnoreCase(search);
    }

}
