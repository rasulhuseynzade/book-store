package com.example.bookstore.model;

import com.example.bookstore.model.enums.Currency;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComicsViewDto {
    private Long id;
    private String name;
    private String category;
    @Size(min = 5, max = 18)
    private String ISBN;
    private String vol;
    private int numberOfPages;
    private LocalDate publicationDate;
    private Currency currency;
    @PositiveOrZero
    private BigDecimal price;
    private LocalDateTime createdAt;
}
