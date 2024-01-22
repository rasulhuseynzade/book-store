package com.example.bookstore.controller;

import com.example.bookstore.model.AuthorViewDto;
import com.example.bookstore.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;
    @GetMapping
    public Page<AuthorViewDto> getAuthorList(Pageable pageable) {
        return authorService.getAuthorList(pageable);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addAuthor(@RequestBody @Valid AuthorViewDto authorViewDto) {
        authorService.addAuthor(authorViewDto);
    }
    @PutMapping("/{authorId}")
    public void updateAuthor(
            @PathVariable Long authorId,
            @RequestBody AuthorViewDto authorViewDto
    ) {
        authorService.updateAuthor(authorId, authorViewDto);
    }
    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
    }

    @GetMapping("/{authorId}")
    public AuthorViewDto getAuthor(@PathVariable Long authorId) {
        return authorService.getAuthor(authorId);
    }
}
