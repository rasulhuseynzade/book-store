package com.example.bookstore.model;

import com.example.bookstore.dao.entity.AuthorEntity;
import com.example.bookstore.model.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class BookDto {
    List<AuthorEntity> authorEntity;
    private Long id;
    private String name;
    private String author;
    private BigDecimal price;
    private Currency currency;
    private String section;
    private String genre;
    private LocalDate originDate;
    private LocalDateTime createAt;
}
