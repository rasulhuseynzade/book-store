package com.example.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookFilterDto {
    private String name;
    private String genre;
    private BigDecimal priceFrom;
    private BigDecimal priceTo;
}
