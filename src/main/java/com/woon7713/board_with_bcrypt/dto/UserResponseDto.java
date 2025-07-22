package com.woon7713.board_with_bcrypt.dto;

import com.woon7713.board_with_bcrypt.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    @NotNull
    private Long id;

    @NotBlank
    private String username;

    public static UserResponseDto fromEntity(User user){
        return new UserResponseDto(
                user.getId(), user.getUsername()
        );
    }

}