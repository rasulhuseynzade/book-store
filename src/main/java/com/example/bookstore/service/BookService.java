package com.example.bookstore.service;

import com.example.bookstore.dao.repository.BookRepository;
import com.example.bookstore.exception.NotFoundException;
import com.example.bookstore.mapper.BookMapper;
import com.example.bookstore.model.BookFilterDto;
import com.example.bookstore.model.BookViewDto;
import com.example.bookstore.service.specification.BookGenreSpecification;
import com.example.bookstore.service.specification.BookNameSpecification;
import com.example.bookstore.service.specification.BookPriceSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    public Page<BookViewDto> getBookList(Pageable pageable, BookFilterDto bookFilterDto) {

        var specification = Specification.where(new BookNameSpecification(bookFilterDto.getName()))
                .and(new BookGenreSpecification(bookFilterDto.getGenre()))
                .and(new BookPriceSpecification(bookFilterDto.getPriceFrom(),bookFilterDto.getPriceTo()));

        var bookEntityList = bookRepository.findAll(specification, pageable);

        var list = bookEntityList.stream()
                .map(bookMapper::entityToDto)
                .collect(Collectors.toList());

        return new PageImpl<>(list, pageable, pageable.getPageSize());
    }

    public void addBook(BookViewDto bookViewDto) {
        log.info("BookViewDto:{}", bookViewDto);
        var bookEntity = bookMapper.dtoToEntity(bookViewDto);
        log.info("BookViewDto;{}", bookEntity);
        bookRepository.save(bookEntity);
    }
    public void updateBook(Long bookId, BookViewDto bookViewDto) {
        log.info("BookViewDto:{}", bookViewDto);
        var bookEntity = bookMapper.dtoToEntity(bookId, bookViewDto);
        log.info("bookEntity;{}", bookEntity);
        bookRepository.save(bookEntity);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public BookViewDto getBook(Long bookId) {
        var bookEntity = bookRepository.findById(bookId).orElseThrow(
                () -> new NotFoundException("BOOK_NOT_FOUND")
        );
        return bookMapper.entityToDto(bookEntity);
    }
}

