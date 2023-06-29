package com.example.springlevel2.controller;

import com.example.springlevel2.dto.PostRequestDto;
import com.example.springlevel2.dto.PostResponseDto;
import com.example.springlevel2.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 게시글 작성
    @PostMapping("/posts")
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostRequestDto requestDto) {
        PostResponseDto responseDto = postService.createPost(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 전체 게시글 조회
    @GetMapping("/posts")
    public List<PostResponseDto> getPosts() {
        return postService.getPosts();
    }

    // 선택한 게시글 조회
    @GetMapping("/posts/{id}")
    public PostResponseDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    // 선택한 게시글 수정
    @PutMapping("/posts/{id}")
    public ResponseEntity<PostResponseDto> updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        PostResponseDto responseDto = postService.updatePost(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 선택한 게시글 삭제
//    @DeleteMapping("/posts/{id}")
//    public PostResponseDto deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
//
//    }
}
