package com.example.bookstore.dao.repository;

import com.example.bookstore.dao.entity.UserEntity;
import com.example.bookstore.model.auth.RegisterRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity>findByEmail(String email);
    void save(RegisterRequestDto user);
}
