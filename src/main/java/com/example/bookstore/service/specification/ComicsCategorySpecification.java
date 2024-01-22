package com.example.bookstore.service.specification;

import com.example.bookstore.dao.entity.ComicsEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ComicsCategorySpecification implements Specification<ComicsEntity> {
    private String category;

    public ComicsCategorySpecification(String category) {
        this.category = category;
    }

    @Override
    public Predicate toPredicate(Root<ComicsEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(category == null || category.isBlank()){
            return null;
        }
        return criteriaBuilder.equal(root.get("category"), category);
    }
}
