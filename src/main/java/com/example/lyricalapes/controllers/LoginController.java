package com.example.lyricalapes.controllers;

import com.example.lyricalapes.models.User;
import com.example.lyricalapes.repositories.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LoginController {

    private UserRepo usersDAO;
    private PasswordEncoder passwordEncoder;

    public LoginController(UserRepo usersDAO, PasswordEncoder passwordEncoder) {
        this.usersDAO = usersDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String showLogIn(Model model, @RequestParam(required = false) Boolean registered) {
        model.addAttribute("pageTitle", "Login");
        if (Boolean.TRUE.equals(registered)) {
            model.addAttribute("registered", true);
        }
        return "users/login";
    }



    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Sign Up");
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        System.out.println(user.getPassword());
        user.setPassword(hash);
        usersDAO.save(user);
        return "redirect:/login?registered=true";

    }
}
