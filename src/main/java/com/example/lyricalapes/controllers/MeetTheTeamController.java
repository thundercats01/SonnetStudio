package com.example.lyricalapes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/")
@Controller
public class MeetTheTeamController {

    @GetMapping("/meettheteam")
    public String showMeetTheTeam (Model model){
        model.addAttribute("pageTitle", "Meet The Team");
        return "profile/meettheteam";
    }

}
