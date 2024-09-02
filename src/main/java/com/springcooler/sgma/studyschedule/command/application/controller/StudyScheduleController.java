package com.springcooler.sgma.studyschedule.command.application.controller;

import com.springcooler.sgma.studyschedule.command.application.dto.StudyScheduleDTO;
import com.springcooler.sgma.studyschedule.command.application.service.AppStudyScheduleService;
import com.springcooler.sgma.studyscheduleparticipant.command.application.service.AppStudyScheduleParticipantService;
import com.springcooler.sgma.studyschedule.command.domain.aggregate.StudySchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/study-schedule")
public class StudyScheduleController {

    private final AppStudyScheduleService studyScheduleService;
    private final AppStudyScheduleParticipantService participantService;

    @Autowired
    public StudyScheduleController(AppStudyScheduleService studyScheduleService,
                                   AppStudyScheduleParticipantService participantService) {
        this.studyScheduleService = studyScheduleService;
        this.participantService = participantService;
    }

    // 스터디 일정 생성
    @PostMapping("/")
    public ResponseEntity<?> registStudySchedule(@RequestBody StudyScheduleDTO createStudySchedule) {
        try {
            StudySchedule createdSchedule = studyScheduleService.registStudySchedule(createStudySchedule);
            return ResponseEntity
                    .created(URI.create("/api/study-schedule/" + createdSchedule.getScheduleId()))
                    .body(createdSchedule);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 스터디 일정 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> modifyStudySchedule(@PathVariable Long id, @RequestBody StudyScheduleDTO updateStudySchedule) {
        StudySchedule updatedSchedule = studyScheduleService.modifyStudySchedule(id, updateStudySchedule);
        return updatedSchedule != null ? ResponseEntity.ok(updatedSchedule) : ResponseEntity.notFound().build();
    }

    // 스터디 일정 삭제 (논리 삭제)
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteStudySchedule(@PathVariable Long id) {
//        studyScheduleService.deleteStudySchedule(id);
//        return ResponseEntity.noContent().build();
//    }
}
