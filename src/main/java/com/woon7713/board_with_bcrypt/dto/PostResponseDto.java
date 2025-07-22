package com.woon7713.board_with_bcrypt.dto;

import com.woon7713.board_with_bcrypt.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {
    private String title;
    private String content;
    private UserResponseDto author;

    public static PostResponseDto fromEntity(Post post) {
        return new PostResponseDto(
                post.getTitle(),
                post.getContent(),
                UserResponseDto.fromEntity(post.getAuthor())
        );
    }
}