package com.example.springlevel2.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;
    private String content;
    private String author;
    private String password;
}
