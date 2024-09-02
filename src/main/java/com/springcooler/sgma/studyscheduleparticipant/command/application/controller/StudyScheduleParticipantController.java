package com.springcooler.sgma.studyscheduleparticipant.command.application.controller;

import com.springcooler.sgma.problem.query.common.ResponseMessage;
import com.springcooler.sgma.studyscheduleparticipant.command.application.service.AppStudyScheduleParticipantService;
import com.springcooler.sgma.studyscheduleparticipant.command.application.dto.StudyScheduleParticipantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

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

    // 스터디 일정 참가자 문제 수 업데이트
//    @PutMapping("/participant/{scheduleId}/{memberId}")
//    public ResponseEntity<?> updateParticipantProblemCount(@PathVariable Long scheduleId, @PathVariable Long memberId) {
//        ResponseMessage responseMessage = studyScheduleParticipantService.updateParticipantProblemCount(scheduleId, memberId);
//        return ResponseEntity.ok(responseMessage);
//    }

    // 특정 참가자의 시험 점수와 백분율 계산
//    @GetMapping("/participantScore/{scheduleId}/{memberId}")
//    public ResponseEntity<?> calculateParticipantScore(@PathVariable Long scheduleId, @PathVariable Long memberId) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
//        Map<String, Object> responseMap = new HashMap<>();
//
//        // 점수 및 백분율 계산 호출
//        Map<String, Double> scoreData = studyScheduleParticipantService.calculateParticipantScore(scheduleId, memberId);
//
//        responseMap.put("score", scoreData.get("score"));
//        responseMap.put("percentage", scoreData.get("percentage"));
//
//        ResponseMessage responseMessage = new ResponseMessage(200, "참가자의 시험 점수 및 백분율 계산 완료", responseMap);
//        return ResponseEntity.ok(responseMessage);
//    }
}
