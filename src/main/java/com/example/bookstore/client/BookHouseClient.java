package com.example.bookstore.client;

import com.example.bookstore.model.BookHouseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "BookHouseClient", url = "https://goodreads-books.p.rapidapi.com/authors/3389/books")
public interface BookHouseClient {

    @GetMapping
    List<BookHouseDto> getBookList(
            @RequestHeader("X-RapidAPI-Key") String apiKey,
            @RequestHeader("X-RapidAPI-Host") String apiHost
    );
  }

