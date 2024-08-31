package com.springcooler.sgma.studyschedule.query.controller;

import com.springcooler.sgma.studyschedule.query.common.ResponseMessage;
import com.springcooler.sgma.studyschedule.query.dto.StudyScheduleDTO;
import com.springcooler.sgma.studyschedule.query.service.StudyScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController("queryStudyScheduleController")
@RequestMapping("/api/study-schedule")
public class StudyScheduleController {

    private final StudyScheduleService studyScheduleService;

    @Autowired
    public StudyScheduleController(StudyScheduleService studyScheduleService) {
        this.studyScheduleService = studyScheduleService;
    }

    @GetMapping("/groupSchedule/{groupId}")
    public ResponseEntity<ResponseMessage> findStudyScheduleByGroupId(@PathVariable long groupId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        // 그룹 ID로 모든 일정 조회
        List<StudyScheduleDTO> schedules = studyScheduleService.findStudyScheduleByGroupId(groupId);

        if (schedules.isEmpty()) {
            // 일정이 없는 경우, 에러 메시지 반환
            ResponseMessage responseMessage = new ResponseMessage(404, "해당 그룹 ID에 대한 일정을 찾을 수 없습니다.", null);
            return new ResponseEntity<>(responseMessage, headers, HttpStatus.NOT_FOUND);
        }

        // 결과 맵 생성
        Map<String, Object> responseMap = schedules.stream()
                .collect(
                        Collectors.toMap(
                                schedule -> String.valueOf(schedule.getScheduleId()), // 키를 String으로 변환
                                Function.identity()
                        )
                );

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/schedule/{scheduleId}")
    public ResponseEntity<ResponseMessage> findStudyScheduleByScheduleId(@PathVariable long scheduleId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        Map<String, Object> responseMap = studyScheduleService.findStudyScheduleByScheduleId(scheduleId)
                .stream()
                .collect(
                        Collectors.toMap(
                                schedule -> String.valueOf(schedule.getScheduleId()),
                                Function.identity()
                        )
                );

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }
}