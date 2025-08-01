package com.woon7713.board_with_bcrypt.repository;

import com.woon7713.board_with_bcrypt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}
