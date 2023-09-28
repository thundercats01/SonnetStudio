package com.gptlibs.fullstackgptlibs.controllers;

import com.gptlibs.fullstackgptlibs.models.MadLib;
import com.gptlibs.fullstackgptlibs.models.User;
import com.gptlibs.fullstackgptlibs.repositories.MadLibRepo;
import com.gptlibs.fullstackgptlibs.repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/play")
public class MadLibPlayController {

    MadLibRepo madLibsDAO;
    UserRepo usersDAO;

    public MadLibPlayController(MadLibRepo madlibDAO, UserRepo userDAO) {
        this.madLibsDAO = madlibDAO;
        this.usersDAO = userDAO;
    }

    @GetMapping
    public String showGameStart() {
        return "play/index";
    }

    @GetMapping("/show")
    public String showGameStory(Model model) {
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = usersDAO.findByUsername(loggedInPrinciple.getUsername());

        model.addAttribute("stories", madLibsDAO.findMadLibByUser(loggedInUser));
//        model.addAttribute("stories", madLibsDAO.findAll());
        return "explore-page";
    }

    @PostMapping
    public String getMadLibParams(@RequestParam String adj, @RequestParam String adv, @RequestParam String noun, @RequestParam String verb) {
        User loggedInPrinciple = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = usersDAO.findByUsername(loggedInPrinciple.getUsername());

        MadLib madlib = new MadLib();
        madlib.setAdj(adj);
        madlib.setAdv(adv);
        madlib.setNoun(noun);
        madlib.setVerb(verb);
        madlib.setUser(loggedInUser);
        madlib.setStory();


        madLibsDAO.save(madlib);
        return "redirect:/play/show";

    }
}
