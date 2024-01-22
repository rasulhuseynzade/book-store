package com.example.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComicsFilterDto {
    private String category;
    private String vol;
    private BigDecimal priceFrom;
    private BigDecimal priceTo;
}
