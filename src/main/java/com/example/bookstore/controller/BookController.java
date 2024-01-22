package com.example.bookstore.controller;

import com.example.bookstore.model.BookFilterDto;
import com.example.bookstore.model.BookViewDto;
import com.example.bookstore.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping
    public Page<BookViewDto> getBookList(
            @PageableDefault(size = 4, page = 0, sort = "id") Pageable pageable,
            BookFilterDto bookFilterDto
    ) {

        return bookService.getBookList(pageable, bookFilterDto);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody @Valid BookViewDto bookViewDto) {
        bookService.addBook(bookViewDto);
    }
    @PutMapping("/{bookId}")
    public void updateBook(
            @PathVariable Long bookId,
            @RequestBody BookViewDto bookViewDto
    ) {
        bookService.updateBook(bookId, bookViewDto);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);

    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{bookId}")
    public BookViewDto getBook(@PathVariable Long bookId) {

        return bookService.getBook(bookId);
    }
}


