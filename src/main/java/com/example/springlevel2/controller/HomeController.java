package com.example.springlevel2.controller;

import com.example.springlevel2.dto.UserRequsetDto;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HomeController {
    @PostMapping("/users/signup")
    public void signup(@RequestBody UserRequsetDto requsetDto) {

    }

    @PostMapping("/users/login")
    public void login(@RequestBody UserRequsetDto requsetDto) {

    }
}
