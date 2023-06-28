package com.example.springlevel2.controller;

import com.example.springlevel2.dto.PostRequestDto;
import com.example.springlevel2.dto.PostResponseDto;
import com.example.springlevel2.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        return blogService.createPost(requestDto);
    }

    @GetMapping("/posts")
    public List<PostResponseDto> getPosts() {
        return blogService.getPosts();
    }

    @GetMapping("/posts/{id}")
    public PostResponseDto getPostById(@PathVariable Long id) {
        return blogService.getPostById(id);
    }

    @PutMapping("/posts/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return blogService.updatePost(id, requestDto);
    }

    @DeleteMapping("/posts/{id}")
    public String deletePost(@PathVariable Long id) {
        return blogService.deletePost(id);
    }

}
