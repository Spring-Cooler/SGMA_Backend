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
    @PostMapping("/participant")
    public ResponseEntity<?> registerParticipant(@RequestBody StudyScheduleParticipantDTO newParticipant) {
        studyScheduleParticipantService.registStudyScheduleParticipant(newParticipant);
        return ResponseEntity.ok("참가자가 성공적으로 추가되었습니다.");
    }

    // 스터디 일정 참가자 삭제
    @DeleteMapping("/participant/{participantId}")
    public ResponseEntity<?> deleteParticipant(@PathVariable Long participantId) {
        studyScheduleParticipantService.deleteStudyScheduleParticipant(participantId);
        return ResponseEntity.noContent().build();
    }
}