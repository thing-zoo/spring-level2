package com.example.springlevel2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class HomeController {
    @GetMapping("/users/signup")
    public ResponseEntity home(Model model) {
        model.addAttribute("username", "username");

    }
}
