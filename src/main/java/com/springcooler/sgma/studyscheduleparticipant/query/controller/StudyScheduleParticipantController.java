package com.springcooler.sgma.studyscheduleparticipant.query.controller;

import com.springcooler.sgma.studyscheduleparticipant.query.common.ResponseMessage;
import com.springcooler.sgma.studyscheduleparticipant.query.dto.StudyScheduleParticipantDTO;
import com.springcooler.sgma.studyscheduleparticipant.query.service.StudyScheduleParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController("queryStudyScheduleParticipantController")
@RequestMapping("/api/study-schedule")
public class StudyScheduleParticipantController {
    private final StudyScheduleParticipantService studyScheduleParticipantService;

    @Autowired
    public StudyScheduleParticipantController(StudyScheduleParticipantService studyScheduleParticipantService) {
        this.studyScheduleParticipantService = studyScheduleParticipantService;
    }

    // 스터디 그룹 일정 참가자 조회
    @GetMapping("/scheduleParticipant/{scheduleId}")
    public ResponseEntity<ResponseMessage> findScheduleParticipantByScheduleId(@PathVariable long scheduleId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        List<StudyScheduleParticipantDTO> participants = studyScheduleParticipantService.findStudyScheduleParticipant(scheduleId);

        if(participants.isEmpty()) {
            ResponseMessage responseMessage = new ResponseMessage(404, "해당 일정 ID에 대한 참가자 정보를 찾을 수 없습니다.", null);
            return new ResponseEntity<>(responseMessage, headers, HttpStatus.NOT_FOUND);
        }

        Map<String, Object> responseMap = participants
                .stream()
                .collect(Collectors.toMap(
                                participant -> String.valueOf(participant.getParticipantId()), // 키는 participantId로 설정
                                Function.identity()
                        )
                );

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    // 스터디 그룹 일정 참가자의 시험결과 조회
    @GetMapping("/participantTestResult/{memberId}")
    public ResponseEntity<ResponseMessage> findParticipantTestResult(@PathVariable long memberId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        List<StudyScheduleParticipantDTO> participantTestResults = studyScheduleParticipantService.findStudyScheduleParticipantTestResult(memberId);

        if (participantTestResults.isEmpty()) {
            ResponseMessage responseMessage = new ResponseMessage(404, "일정 및 참가자에 대한 시험 결과를 찾을 수 없습니다.", null);
            return new ResponseEntity<>(responseMessage, headers, HttpStatus.NOT_FOUND);
        }

        Map<String, Object> responseMap = participantTestResults
                .stream()
                .collect(Collectors.toMap(
                        participant -> String.valueOf(participant.getParticipantId()),
                        Function.identity()
                ));

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

}