package com.example.springlevel2.controller;

import com.example.springlevel2.dto.UserRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HomeController {
    @PostMapping("/users/signup")
    public void signup(@RequestBody UserRequestDto requsetDto) {

    }

    @PostMapping("/users/login")
    public void login(@RequestBody UserRequestDto requsetDto) {

    }
}
