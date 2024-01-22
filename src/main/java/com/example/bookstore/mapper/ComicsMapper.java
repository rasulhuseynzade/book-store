package com.example.bookstore.mapper;

import com.example.bookstore.dao.entity.ComicsEntity;
import com.example.bookstore.model.ComicsViewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ComicsMapper {


    ComicsViewDto entityToDto(ComicsEntity comicsEntity);
    ComicsEntity dtoToEntity(ComicsViewDto comicsViewDto);
    @Mapping(target = "id", source = "id")
    ComicsEntity dtoToEntity(Long id, ComicsViewDto comicsViewDto);
}
