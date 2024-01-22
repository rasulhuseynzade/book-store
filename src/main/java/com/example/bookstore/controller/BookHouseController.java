package com.example.bookstore.controller;

import com.example.bookstore.model.BookHouseDto;
import com.example.bookstore.service.BookHouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/good-reads")
@RequiredArgsConstructor
public class BookHouseController{
    private final BookHouseService bookHouseService;

    @GetMapping
    public List<BookHouseDto> getBookList() {
        return bookHouseService.getBookList();
    }
}
