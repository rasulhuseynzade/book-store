package com.example.bookstore.service;

import com.example.bookstore.dao.repository.MeetingRepository;
import com.example.bookstore.mapper.MeetingMapper;
import com.example.bookstore.model.MeetingViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeetingService {
    private final MeetingRepository meetingRepository;
    private final MeetingMapper meetingMapper;

    public Page<MeetingViewDto> getMeetingList(Pageable pageable) {
        var meetingEntity = meetingRepository.findAll(pageable);
        var list = meetingEntity.stream()
                .map(meetingMapper::entityToDto)
                .collect(Collectors.toList());

        return new PageImpl<>(list, pageable, pageable.getPageNumber());
    }

    public void addMeeting(MeetingViewDto meetingViewDto) {
        var meetingEntity = meetingMapper.dtoToEntity(meetingViewDto);
        meetingRepository.save(meetingEntity);
    }

    public void updateMeeting(Long meetingId, MeetingViewDto meetingViewDto) {
        var meetingEntity = meetingMapper.dtoToEntity(meetingId, meetingViewDto);
        meetingRepository.save(meetingEntity);
    }

    public void deleteMeeting(Long meetingId) {

        meetingRepository.deleteById(meetingId);
    }
}
