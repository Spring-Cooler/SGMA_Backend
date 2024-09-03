package com.springcooler.sgma.studyschedule.command.application.controller;

import com.springcooler.sgma.studyschedule.command.application.dto.StudyScheduleDTO;
import com.springcooler.sgma.studyschedule.command.application.service.AppStudyScheduleService;
import com.springcooler.sgma.studyschedule.command.domain.aggregate.StudySchedule;
import com.springcooler.sgma.problem.query.common.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/study-schedule")
public class StudyScheduleController {

    private final AppStudyScheduleService studyScheduleService;

    @Autowired
    public StudyScheduleController(AppStudyScheduleService studyScheduleService) {
        this.studyScheduleService = studyScheduleService;
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
    @PutMapping("/{scheduleId}")
    public ResponseEntity<?> modifyStudySchedule(@PathVariable Long scheduleId, @RequestBody StudyScheduleDTO updateStudySchedule) {
        StudySchedule updatedSchedule = studyScheduleService.modifyStudySchedule(scheduleId, updateStudySchedule);
        return updatedSchedule != null ? ResponseEntity.ok(updatedSchedule) : ResponseEntity.notFound().build();
    }

    // 스터디 일정 삭제
    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<?> deleteStudySchedule(@PathVariable Long scheduleId) {
        studyScheduleService.deleteStudySchedule(scheduleId);
        return ResponseEntity.noContent().build();
    }

    // 시험 평균과 표준편차 업데이트
    @PutMapping("/updateScores/{scheduleId}")
    public ResponseEntity<?> updateScheduleScores(@PathVariable Long scheduleId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();

        studyScheduleService.updateScheduleWithParticipantScores(scheduleId);

        ResponseMessage responseMessage = new ResponseMessage(200, "일정의 시험 평균 및 표준편차 업데이트 완료", responseMap);
        return ResponseEntity.ok(responseMessage);
    }
}
