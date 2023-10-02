package com.example.lyricalapes.controllers;

import com.example.lyricalapes.repositories.BadgeRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BadgePageController {

    BadgeRepo BadgesDao;

    public BadgePageController(BadgeRepo badgesDao) {
        BadgesDao = badgesDao;
    }

    @GetMapping("/badge")
    public String showBadgePage() {
        return "profile/badge";
    }

}
