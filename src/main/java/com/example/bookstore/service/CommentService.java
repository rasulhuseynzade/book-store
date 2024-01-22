package com.example.bookstore.service;


import com.example.bookstore.dao.repository.BookRepository;
import com.example.bookstore.dao.repository.CommentRepository;
import com.example.bookstore.exception.NotFoundException;
import com.example.bookstore.mapper.CommentMapper;
import com.example.bookstore.model.CommentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class CommentService {
    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;
    private final CommentMapper commentMapper;

    public CommentService(CommentRepository commentRepository, BookRepository bookRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.bookRepository = bookRepository;
        this.commentMapper = commentMapper;
    }

    public void addComment(CommentDto commentDto) {
        bookRepository.findById(commentDto.getBookId()).orElseThrow(
                () -> new NotFoundException("BOOK_NOT_FOUND")
        );
        var commentEntity = commentMapper.dtoToEntity(commentDto);

        commentRepository.save(commentEntity);

    }

    public CommentDto getComment(Long commentId) {
        var commentEntity = commentRepository.findById(commentId).orElseThrow(
                () -> new NotFoundException("COMMENT_NOT_FOUND")
        );
        return commentMapper.entityToDto(commentEntity);
    }

    public void updateComment(Long commentId, CommentDto commentDto) {
        log.info("CommentDto:{}", commentDto);
        var commentEntity = commentMapper.dtoToEntity(commentId, commentDto);
        log.info("commentEntity;{}", commentEntity);
        commentRepository.save(commentEntity);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}

