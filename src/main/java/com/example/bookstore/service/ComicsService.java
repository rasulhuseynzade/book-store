package com.example.bookstore.service;

import com.example.bookstore.dao.repository.ComicsRepository;
import com.example.bookstore.mapper.ComicsMapper;
import com.example.bookstore.model.ComicsFilterDto;
import com.example.bookstore.model.ComicsViewDto;
import com.example.bookstore.service.specification.ComicsCategorySpecification;
import com.example.bookstore.service.specification.ComicsPriceSpecification;
import com.example.bookstore.service.specification.ComicsVolSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComicsService {
    private final ComicsRepository comicsRepository;
    private final ComicsMapper comicsMapper;

    public Page<ComicsViewDto> getComicsList(Pageable pageable, ComicsFilterDto comicsFilterDto) {
        var specification = Specification.where(new ComicsCategorySpecification(comicsFilterDto.getCategory()))
                .and(new ComicsVolSpecification(comicsFilterDto.getVol()))
                .and(new ComicsPriceSpecification(comicsFilterDto.getPriceFrom(), comicsFilterDto.getPriceTo()));

        var comicsEntityList = comicsRepository.findAll(specification, pageable);
        var list = comicsEntityList.stream()
                .map(comicsMapper::entityToDto)
                .collect(Collectors.toList());

        return new PageImpl<>(list, pageable, pageable.getPageSize());
    }

    public void addComics(ComicsViewDto comicsViewDto) {
        var comicsEntity = comicsMapper.dtoToEntity(comicsViewDto);
        comicsRepository.save(comicsEntity);

    }

    public void updateComics(Long comicsId, ComicsViewDto comicsViewDto) {
        var comicsEntity = comicsMapper.dtoToEntity(comicsId, comicsViewDto);
        comicsRepository.save(comicsEntity);

    }

    public void deleteComics(Long comicsId) {
        comicsRepository.deleteById(comicsId);
    }

    public ComicsViewDto getComics(Long comicsId) {
        var comicsEntity = comicsRepository.findById(comicsId).orElseThrow(
                () -> new RuntimeException("COMICS_NOT_FOUND")
        );
        return comicsMapper.entityToDto(comicsEntity);
    }
}
