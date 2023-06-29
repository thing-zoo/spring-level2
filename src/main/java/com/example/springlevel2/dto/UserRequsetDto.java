package com.example.springlevel2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserRequsetDto {
    @NotBlank
    @Pattern(regexp = "^[a-z0-9]{4,10}$")
    private String username;

    @NotBlank
    @Pattern(regexp = "^(?=.?[A-Z])(?=.?[a-z])(?=.?[0-9]).{8,15}$")
    private String password;
}
