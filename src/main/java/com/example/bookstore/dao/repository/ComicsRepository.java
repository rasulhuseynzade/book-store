package com.example.bookstore.dao.repository;

import com.example.bookstore.dao.entity.ComicsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ComicsRepository extends JpaRepository<ComicsEntity, Long>, JpaSpecificationExecutor<ComicsEntity> {
}
