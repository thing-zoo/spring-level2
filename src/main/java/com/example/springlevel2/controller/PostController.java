package com.example.springlevel2.controller;

import com.example.springlevel2.dto.PostRequestDto;
import com.example.springlevel2.dto.PostResponseDto;
import com.example.springlevel2.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<PostResponseDto> createPost(@RequestHeader("Authorization") String token,
                                                      @RequestBody @Valid PostRequestDto requestDto) {
        PostResponseDto responseDto = postService.createPost(token, requestDto);

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
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
    public ResponseEntity<PostResponseDto> updatePost(@RequestHeader("Authorization") String token,
                                                      @PathVariable Long id,
                                                      @RequestBody @Valid PostRequestDto requestDto) {
        PostResponseDto responseDto = postService.updatePost(id, token, requestDto);

        return ResponseEntity.ok(responseDto);
    }

    // 선택한 게시글 삭제
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<String> deletePost(@RequestHeader("Authorization") String token,
                                             @PathVariable Long id) {
        String res = postService.deletePost(token, id);
        return ResponseEntity.ok().body(res);
    }
}
