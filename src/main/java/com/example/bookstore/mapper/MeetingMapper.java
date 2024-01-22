package com.example.bookstore.mapper;

import com.example.bookstore.dao.entity.MeetingEntity;
import com.example.bookstore.model.MeetingViewDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MeetingMapper {

    MeetingViewDto entityToDto(MeetingEntity meetingEntity);
    MeetingEntity dtoToEntity(MeetingViewDto meetingViewDto);

    MeetingEntity dtoToEntity(Long id, MeetingViewDto meetingViewDto);
}
