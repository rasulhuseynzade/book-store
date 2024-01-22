package com.example.bookstore.service.specification;

import com.example.bookstore.dao.entity.BookEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class BookGenreSpecification implements Specification<BookEntity> {

    private String genre;

    public BookGenreSpecification(String genre) {
        this.genre = genre;
    }

    @Override
    public Predicate toPredicate(Root<BookEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (genre == null || genre.isBlank()) {
            return null;
        }
        return criteriaBuilder.equal(root.get("genre"), genre);
    }
}

