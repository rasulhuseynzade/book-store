package com.example.bookstore.controller;

import com.example.bookstore.model.MeetingViewDto;
import com.example.bookstore.service.MeetingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/meetings")
@RequiredArgsConstructor
public class MeetingController {
    private final MeetingService meetingService;

    @GetMapping
    public Page<MeetingViewDto> getMeetingList(Pageable pageable) {
        return meetingService.getMeetingList(pageable);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addMeeting(@RequestBody @Valid MeetingViewDto meetingViewDto) {
        meetingService.addMeeting(meetingViewDto);

    }

    @PutMapping("/{meetingId}")
    public void updateMeeting(
            @PathVariable Long meetingId,
            @RequestBody MeetingViewDto meetingViewDto
    ) {
        meetingService.updateMeeting(meetingId, meetingViewDto);

    }

    @DeleteMapping("/{meetingId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMeeting(@PathVariable Long meetingId) {
        meetingService.deleteMeeting(meetingId);

    }
}
