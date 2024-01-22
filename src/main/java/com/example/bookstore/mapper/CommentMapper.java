package com.example.bookstore.mapper;

import com.example.bookstore.dao.entity.CommentEntity;
import com.example.bookstore.model.CommentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentEntity dtoToEntity(CommentDto commentDto);

    CommentDto entityToDto(CommentEntity commentEntity);
    @Mapping(target = "id", source = "id")
    CommentEntity dtoToEntity(Long id, CommentDto commentDto);


}
