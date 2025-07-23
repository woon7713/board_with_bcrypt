package com.woon7713.board_with_bcrypt.controller;


import com.woon7713.board_with_bcrypt.dto.PostRequestDto;
import com.woon7713.board_with_bcrypt.dto.PostResponseDto;
import com.woon7713.board_with_bcrypt.dto.UserRequestDto;
import com.woon7713.board_with_bcrypt.model.Post;
import com.woon7713.board_with_bcrypt.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public List<PostResponseDto> listAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());

        return postService.listAll(pageable);
    }

    @GetMapping("/{id}")
    public PostResponseDto get(@PathVariable Long id) {
        return postService.getById(id);
    }

    @PostMapping
    public PostResponseDto create(@Valid @RequestBody PostRequestDto dto) {
        return postService.create(dto);
    }

    @PutMapping("/{id}")
    public PostResponseDto update(@PathVariable Long id, @Valid @RequestBody PostRequestDto dto) {
        return postService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, @Valid @RequestBody UserRequestDto dto) {
        postService.delete(id, dto);
    }

}