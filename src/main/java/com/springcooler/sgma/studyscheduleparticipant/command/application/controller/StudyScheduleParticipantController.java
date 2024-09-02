package com.springcooler.sgma.studyscheduleparticipant.command.application.controller;

import com.springcooler.sgma.studyscheduleparticipant.command.application.dto.StudyScheduleParticipantDTO;
import com.springcooler.sgma.studyscheduleparticipant.command.application.service.AppStudyScheduleParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/study-schedule")
public class StudyScheduleParticipantController {
    private final AppStudyScheduleParticipantService studyScheduleParticipantService;

    @Autowired
    public StudyScheduleParticipantController(AppStudyScheduleParticipantService studyScheduleParticipantService) {
        this.studyScheduleParticipantService = studyScheduleParticipantService;
    }

    // 스터디 일정 참가자 등록
    @PostMapping("/participant/{scheduleId}")
    public ResponseEntity<?> registerParticipant(@PathVariable Long scheduleId, @RequestBody StudyScheduleParticipantDTO newParticipant) {
        newParticipant.setScheduleId(scheduleId);
        return ResponseEntity.ok(studyScheduleParticipantService.registStudyScheduleParticipant(newParticipant));
    }

    // 스터디 일정 참가자 삭제
    @DeleteMapping("/participant/{scheduleId}/{memberId}")
    public ResponseEntity<?> cancelParticipant(@PathVariable Long scheduleId, @PathVariable Long memberId) {
        studyScheduleParticipantService.deleteStudyScheduleParticipant(scheduleId, memberId);
        return ResponseEntity.noContent().build();
    }
}