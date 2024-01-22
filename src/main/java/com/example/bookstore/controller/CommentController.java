package com.example.bookstore.controller;

import com.example.bookstore.model.CommentDto;
import com.example.bookstore.service.CommentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/comments")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addComment(@RequestBody @Valid CommentDto commentDto) {
        commentService.addComment(commentDto);
    }

    @GetMapping("/{commentId}")
    public CommentDto getComment(@PathVariable Long commentId) {
        return commentService.getComment(commentId);
    }
    @PutMapping("/{commentId}")
    public void updateComment(
            @PathVariable Long commentId,
            @RequestBody CommentDto commentDto
    ){
        commentService.updateComment(commentId,commentDto);

    }
    @DeleteMapping("/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }

}
