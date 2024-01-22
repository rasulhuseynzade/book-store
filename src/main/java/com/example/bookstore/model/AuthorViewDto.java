package com.example.bookstore.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorViewDto {
    private Long id;
    @NotBlank
    private String name;
    private LocalDate dateOfBirth;
    private String birthplace;

}
