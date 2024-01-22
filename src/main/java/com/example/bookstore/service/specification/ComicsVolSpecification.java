package com.example.bookstore.service.specification;

import com.example.bookstore.dao.entity.ComicsEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ComicsVolSpecification implements Specification<ComicsEntity> {
    private String vol;

    public ComicsVolSpecification(String vol) {
        this.vol = vol;
    }

    @Override
    public Predicate toPredicate(Root<ComicsEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (vol == null || vol.isBlank()) {
            return null;
        }
        return criteriaBuilder.equal(root.get("vol"), vol);
    }
}
