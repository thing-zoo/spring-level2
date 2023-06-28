package com.example.springlevel2.service;

import com.example.springlevel2.dto.PostRequestDto;
import com.example.springlevel2.dto.PostResponseDto;
import com.example.springlevel2.entity.Post;
import com.example.springlevel2.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public PostResponseDto createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);

        Post savedPost = blogRepository.save(post);

        return new PostResponseDto(post);
    }

    public List<PostResponseDto> getPosts() {
        return blogRepository.findAllByOrderByCreatedAtDesc().stream().map(PostResponseDto::new).toList();
    }

    public PostResponseDto getPostById(Long id) {
        return new PostResponseDto(findPost(id));
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostRequestDto requestDto) {
        Post post = findPost(id);
        if (Objects.equals(post.getPassword(), requestDto.getPassword())) {
            post.update(requestDto);
        }
        return new PostResponseDto(post);

    }

    public String deletePost(Long id) {
        Post post = findPost(id);
        try {
            blogRepository.delete(post);
            return "success";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "fail";
        }
    }

    private Post findPost(Long id) {
        return blogRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 post는 존재하지 습니다."));
    }
}
