package com.example.bookstore.mapper;

import com.example.bookstore.dao.entity.AuthorEntity;
import com.example.bookstore.model.AuthorViewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(source = "name", target = "name")
    AuthorViewDto entityToDto(AuthorEntity authorEntity);
    AuthorEntity dtoToEntity(AuthorViewDto authorViewDto);
    AuthorEntity dtoToEntity(Long id, AuthorViewDto authorViewDto);


}


