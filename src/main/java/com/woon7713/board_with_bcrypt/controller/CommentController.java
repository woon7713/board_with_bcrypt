package com.woon7713.board_with_bcrypt.controller;

import com.woon7713.board_with_bcrypt.dto.CommentRequestDto;
import com.woon7713.board_with_bcrypt.dto.CommentResponseDto;
import com.woon7713.board_with_bcrypt.dto.UserRequestDto;
import com.woon7713.board_with_bcrypt.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    public CommentResponseDto create(
            @PathVariable Long postId,
            @Valid @RequestBody CommentRequestDto dto
    ) {
        return commentService.create(postId, dto);
    }

    @PutMapping("/comments/{id}")
    public CommentResponseDto update(
            @PathVariable Long id,
            @Valid @RequestBody CommentRequestDto dto
    ) {
        return commentService.update(id, dto);
    }

    @DeleteMapping("/comments/{id}")
    public void delete(@PathVariable Long id, @Valid @RequestBody UserRequestDto dto) {
        commentService.delete(id, dto);
    }
}