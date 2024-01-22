package com.example.bookstore.controller;

import com.example.bookstore.model.ComicsFilterDto;
import com.example.bookstore.model.ComicsViewDto;
import com.example.bookstore.service.ComicsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comics")
@RequiredArgsConstructor
public class ComicsController {
    private final ComicsService comicsService;
    @GetMapping
    public Page<ComicsViewDto> getComicsList(
            @PageableDefault(size = 4, page = 0, sort = "id") Pageable pageable,
            ComicsFilterDto comicsFilterDto
    ) {
        return comicsService.getComicsList(pageable, comicsFilterDto);
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addComics(@RequestBody @Valid ComicsViewDto comicsViewDto) {
        comicsService.addComics(comicsViewDto);

    }
    @PutMapping("/{comicsId}")
    public void updateComics(
            @PathVariable Long comicsId,
            @RequestBody ComicsViewDto comicsViewDto
    ) {
        comicsService.updateComics(comicsId, comicsViewDto);
    }

    @DeleteMapping("/{comicsId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComics(@PathVariable Long comicsId) {
        comicsService.deleteComics(comicsId);

    }

    @GetMapping("/{comicsId}")
    public ComicsViewDto getComics(@PathVariable Long comicsId) {
        return comicsService.getComics(comicsId);
    }
}
