package com.example.bookstore.service.specification;

import com.example.bookstore.dao.entity.BookEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class BookNameSpecification implements Specification<BookEntity> {
    private String name;

    public BookNameSpecification(String name) {
        this.name = name;
    }

    @Override
    public Predicate toPredicate(Root<BookEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (name == null || name.isBlank()) {
            return null;
        }
        return criteriaBuilder.equal(root.get("name_of_books"), name);
    }
}
