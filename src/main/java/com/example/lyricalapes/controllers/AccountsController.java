//package com.gptlibs.fullstackgptlibs.controllers;
//
//import com.gptlibs.fullstackgptlibs.models.User;
//import com.gptlibs.fullstackgptlibs.repositories.UserRepo;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/accounts")
//public class AccountsController {
//
//    com.gptlibs.fullstackgptlibs.repositories.VerseRepo madLibsDAO;
//    UserRepo usersDAO;
//    private PasswordEncoder passwordEncoder;
//
//    public AccountsController(com.gptlibs.fullstackgptlibs.repositories.VerseRepo madLibsDAO, UserRepo usersDAO, PasswordEncoder passwordEncoder) {
//        this.madLibsDAO = madLibsDAO;
//        this.usersDAO = usersDAO;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @GetMapping("/login")
//    public String showLogIn() {
//        return "accounts/login";
//    }
//
//
//    @GetMapping("/sign-up")
//    public String showSignupForm(Model model) {
//        model.addAttribute("user", new User());
//        return "accounts/sign-up";
//    }
//
//    @PostMapping("/sign-up")
//    public String saveUser(@ModelAttribute User user) {
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        usersDAO.save(user);
//        return "accounts/login";
//    }
//}
