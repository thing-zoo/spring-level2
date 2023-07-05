package com.example.springlevel2.service;

import com.example.springlevel2.dto.PostRequestDto;
import com.example.springlevel2.dto.PostResponseDto;
import com.example.springlevel2.entity.Post;
import com.example.springlevel2.repository.PostRepository;
import com.example.springlevel2.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final JwtUtil jwtUtil;

    public PostResponseDto createPost(String token, PostRequestDto requestDto) {
        String substringToken = jwtUtil.substringToken(token);
        boolean isValidateToken = jwtUtil.validateToken(substringToken);
        String username = jwtUtil.getUsernameFromJwt(token);

        if (isValidateToken) {
            Post post = new Post(requestDto, username);
            Post savedPost = postRepository.save(post);
            return new PostResponseDto(savedPost);
        }

        return null;
    }

    public List<PostResponseDto> getPosts() {
        return postRepository
                .findAllByOrderByCreatedAtDesc()
                .stream()
                .map(PostResponseDto::new)
                .toList();
    }

    public PostResponseDto getPost(Long id) {
        return new PostResponseDto(findPost(id));
    }

    @Transactional
    public PostResponseDto updatePost(Long id, String token, PostRequestDto requestDto) {
        Post post = findPost(id);

        if (isValid(token, post)) {
            post.update(requestDto);

            return new PostResponseDto(post);
        }

        return null;
    }

    public String deletePost(String token, Long id) {
        Post post = findPost(id);

        if (isValid(token, post)) {
            postRepository.delete(post);
            return "게시물 삭제 성공";
        }
        return "게시물 삭제 실패";
    }

    private boolean isValid(String token, Post post) {
        String username = jwtUtil.getUsernameFromJwt(token);

        return username.equals(post.getUsername());
    }

    private Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시물은 존재하지 않습니다."));
    }
}
