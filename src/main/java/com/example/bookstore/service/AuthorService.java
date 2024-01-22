package com.example.bookstore.service;

import com.example.bookstore.dao.repository.AuthorRepository;
import com.example.bookstore.exception.NotFoundException;
import com.example.bookstore.mapper.AuthorMapper;
import com.example.bookstore.model.AuthorViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public Page<AuthorViewDto> getAuthorList(Pageable pageable) {
        var authorEntityList = authorRepository.findAll(pageable);
        var list = authorEntityList.stream()
                .map(authorMapper::entityToDto)
                .collect(Collectors.toList());

        return new PageImpl<>(list, pageable, pageable.getPageSize());
    }

    public void addAuthor(AuthorViewDto authorViewDto) {
        var authorEntity = authorMapper.dtoToEntity(authorViewDto);
        authorRepository.save(authorEntity);

    }

    public void updateAuthor(Long authorId, AuthorViewDto authorViewDto) {
        var authorEntity = authorMapper.dtoToEntity(authorId, authorViewDto);
        authorRepository.save(authorEntity);
    }

    public void deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }

    public AuthorViewDto getAuthor(Long authorId) {
        var authorEntity = authorRepository.findById(authorId).orElseThrow(
                () -> new NotFoundException("AUTHOR_NOT_FOUND")
        );
        return authorMapper.entityToDto(authorEntity);
    }
}

