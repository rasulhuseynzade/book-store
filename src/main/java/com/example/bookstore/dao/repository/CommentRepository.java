package com.example.bookstore.dao.repository;

import com.example.bookstore.dao.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

}