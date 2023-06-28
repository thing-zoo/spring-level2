package com.example.springlevel2.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL) //명시한 값만 json에 포함!!
public class PostRequestDto {
    private String title;
    private String content;
    private String author;
    private String password;
}
