package com.springcooler.sgma.studyschedule.query.controller;

import com.springcooler.sgma.studyschedule.query.common.ResponseMessage;
import com.springcooler.sgma.studyschedule.query.service.StudyScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
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