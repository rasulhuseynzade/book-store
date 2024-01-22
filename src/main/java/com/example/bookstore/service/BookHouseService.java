package com.example.bookstore.service;

import com.example.bookstore.client.BookHouseClient;
import com.example.bookstore.model.BookHouseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookHouseService {
    private final BookHouseClient bookHouseClient;
    public List<BookHouseDto> getBookList() {


        String key =  "2951c4bea4msh23f4d4115656b3fp1d44c8jsn5c8fff8755e5";
        String host = "goodreads-books.p.rapidapi.com";

        return bookHouseClient.getBookList(key, host);
    }
}

