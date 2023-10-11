package com.example.lyricalapes.controllers;

import com.example.lyricalapes.models.Comment;
import com.example.lyricalapes.models.Like;
import com.example.lyricalapes.models.User;
import com.example.lyricalapes.models.Verse;
import com.example.lyricalapes.repositories.CommentRepo;
import com.example.lyricalapes.repositories.LikeRepo;
import com.example.lyricalapes.repositories.UserRepo;
import com.example.lyricalapes.repositories.VerseRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProfileController {

    private UserRepo usersDAO;
    private VerseRepo verseRepo;

    private LikeRepo likesDao;
    private CommentRepo commentRepo;

    public ProfileController(UserRepo usersDAO, VerseRepo verseRepo, LikeRepo likesDao, CommentRepo commentRepo) {
        this.usersDAO = usersDAO;
        this.verseRepo = verseRepo;
        this.likesDao = likesDao;
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

        long totalLikesOfLoggedinUser = 0;
//            for(Verse verse : versesByLoggedInUser) {
        for (Verse verse : loggedInUser.getVerses()) {
            List<Like> likesForThisVerse = likesDao.findAllByVerse(verse);
            System.out.println(likesForThisVerse);
            totalLikesOfLoggedinUser += likesForThisVerse.size();
        }

        List<Comment> commentsPerVerse = new ArrayList<>();
        for (Verse verse : loggedInUser.getVerses()) {
            for (Comment comment : verse.getComments()) {
                commentsPerVerse.add(comment);
            }
        }


        model.addAttribute("verses", verses);
        model.addAttribute("comments", commentRepo.findAll());
        model.addAttribute("username", loggedInUsername);
        model.addAttribute("bio", loggedInUser.getBio());
        model.addAttribute("currentBadge", loggedInUser.getCurrentBadge());
        model.addAttribute("likes", totalLikesOfLoggedinUser);
        model.addAttribute("following", loggedInUser.getFollowers().size());
        model.addAttribute("followers", loggedInUser.getFollowing().size());
        model.addAttribute("totalComments", commentsPerVerse.size());

        return "profile/profileview";
    }


    @GetMapping("/profile/{id}")
    public String ShowOtherUserProfile(@PathVariable Long id, Model model) {
        // Get the logged-in user
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = usersDAO.findByUsername(loggedInPrinciple.getUsername());

        User clickedUser = usersDAO.findById(id).get();

        // Check if the profile being viewed is of the logged-in user
        if (loggedInUser.getId() == clickedUser.getId()) { // <-- Use == for primitive long comparison
            // Fetch posts made by the logged-in user in descending order by ID
            List<Verse> verses = verseRepo.findAllByUserOrderByIdDesc(loggedInUser);

            model.addAttribute("verses", verses);
            model.addAttribute("comments", commentRepo.findAll());
            model.addAttribute("username", loggedInUser.getUsername());
            model.addAttribute("bio", loggedInUser.getBio());
            model.addAttribute("currentBadge", loggedInUser.getCurrentBadge());

            return "profile/profileview";
        } else {
            // Fetch posts and comments made by the clicked user
            List<Verse> verses = verseRepo.findAllByUserOrderByIdDesc(clickedUser);
            model.addAttribute("verses", verses);
            model.addAttribute("comments", commentRepo.findAll());

            // Additional data for the clicked user
            model.addAttribute("user", clickedUser);
            model.addAttribute("bio", clickedUser.getBio());
            model.addAttribute("currentBadge", clickedUser.getCurrentBadge());

//            List<Verse> versesByLoggedInUser = verseRepo.findAllByUserOrderByIdDesc(loggedInUser);
            long totalLikesOfLoggedinUser = 0;
//            for(Verse verse : versesByLoggedInUser) {
            for (Verse verse : loggedInUser.getVerses()) {
                List<Like> likesForThisVerse = likesDao.findAllByVerse(verse);
                System.out.println(likesForThisVerse);
                totalLikesOfLoggedinUser += likesForThisVerse.size();
            }


            return "profile/usersprofileview";
        }
    }


//////  DELETE

    @PostMapping("/post_delete")
    public String RemoveSelectedPost(@RequestParam Long verseId) {
        verseRepo.deleteById(verseId);
        return "redirect:/profile";
    }

    ///////
    @PostMapping("/follow")
    public String FollowThatUser(@RequestParam Long userId) {
        //other user
        User userToFollow = usersDAO.findById(userId).get();
        //logged in user
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = usersDAO.findByUsername(loggedInPrinciple.getUsername());
        /// adds user to my follower list
        loggedInUser.addNewFollower(userToFollow);
        // adds me too their following list
        userToFollow.addNewFollowing(loggedInUser);

        usersDAO.save(loggedInUser);
        usersDAO.save(userToFollow);
        return "redirect:/profile";
    }

    @PostMapping("/like/profile")
    public String handleLikes(@RequestParam("verse-id") Long verseId) {
        System.out.println("inside handleLikes");
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = usersDAO.findByUsername(loggedInPrinciple.getUsername());
        // get user id
        Like like = new Like();
        // get verse id
        // set them to like object
        like.setUser(loggedInUser);
        like.setVerse(verseRepo.findById(verseId).get());
        if (!likesDao.existsByUserAndVerse(like.getUser(), like.getVerse())) {
            // save to likes table
            likesDao.save(like);
        }

        System.out.println("blank");
        return "redirect:/profile";
    }

}
