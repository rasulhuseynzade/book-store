package com.example.bookstore.mapper;

import com.example.bookstore.dao.entity.BookEntity;
import com.example.bookstore.model.BookViewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(source = "comments", target = "comments")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "meetings", target = "meetings")
    @Mapping(source = "author", target = "author")
    BookViewDto entityToDto(BookEntity bookEntity);
    BookEntity dtoToEntity(BookViewDto bookViewDto);
    BookEntity dtoToEntity(Long id, BookViewDto bookViewDto);
}
