package com.example.bookstore.service.specification;

import com.example.bookstore.dao.entity.ComicsEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ComicsPriceSpecification implements Specification<ComicsEntity> {
    private BigDecimal priceFrom;
    private BigDecimal priceTo;

    public ComicsPriceSpecification(BigDecimal priceFrom, BigDecimal priceTo) {
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
    }

    @Override
    public Predicate toPredicate(Root<ComicsEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (priceFrom == null && priceTo == null){
            return null;
        }
        return criteriaBuilder.between(root.get("price"), priceFrom, priceTo);
    }
}
