package com.springcooler.sgma.studyschedule.query.controller;

import com.springcooler.sgma.recruitmentboard.query.dto.RecruitmentBoardDTO;
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
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    // 스터디 그룹 일정 단건 조회
    @GetMapping("/schedule/{scheduleId}")
    public ResponseEntity<?> findStudyScheduleByScheduleId(@PathVariable("scheduleId") Long ScheduleId) {
        try {
            StudyScheduleDTO studyScheduleDTO = studyScheduleService.findStudyScheduleByScheduleId(ScheduleId);
            return ResponseEntity.ok(studyScheduleDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("해당 번호의 글이 존재하지 않습니다");
        }
    }

    // 스터디 그룹 일정 전체 조회
    @GetMapping("/scheduleGroup/{groupId}")
    public ResponseEntity<ResponseMessage> findStudyScheduleByGroupId(@PathVariable long groupId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        List<StudyScheduleDTO> schedules = studyScheduleService.findStudyScheduleByGroupId(groupId);

        if (schedules.isEmpty()) {
            ResponseMessage responseMessage = new ResponseMessage(404, "조회 실패!", null);
            return new ResponseEntity<>(responseMessage, headers, HttpStatus.NOT_FOUND);
        }

        Map<String, Object> responseMap = schedules
                .stream()
                .collect(Collectors.toMap(
                                schedule -> String.valueOf(schedule.getScheduleId()), // 키를 String으로 변환
                                Function.identity()
                        )
                );

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    // 스터디 그룹 일정 기간별 조회
    @GetMapping("/schedulesByPeriod/{groupId}/{startDate}/{endDate}")
    public ResponseEntity<ResponseMessage> findStudySchedulesByPeriod(@PathVariable long groupId, @PathVariable String startDate, @PathVariable String endDate) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        List<StudyScheduleDTO> schedules = studyScheduleService.findStudySchedulesByPeriod(groupId, startDate, endDate);

        if (schedules.isEmpty()) {
            ResponseMessage responseMessage = new ResponseMessage(404, "조회 실패!", null);
            return new ResponseEntity<>(responseMessage, headers, HttpStatus.NOT_FOUND);
        }

        // 날짜 변환을 위해 SimpleDateFormat 사용
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        // 변환된 값을 저장할 리스트 생성
        List<Map<String, Object>> responseList = schedules.stream().map(schedule -> {
            Map<String, Object> scheduleMap = new HashMap<>();

            // Timestamp를 "yyyyMMdd" 형식의 문자열로 변환
            scheduleMap.put("scheduleStartTime", dateFormat.format(schedule.getScheduleStartTime()));
            scheduleMap.put("scheduleEndTime", dateFormat.format(schedule.getScheduleEndTime()));
            scheduleMap.put("schedule", schedule);

            return scheduleMap;
        }).collect(Collectors.toList());

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("schedules", responseList);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    // 스터디 그룹 일정 시험의 통계자료 조회
    @GetMapping("/scheduleStatistics/{scheduleId}")
    public ResponseEntity<ResponseMessage> findStudyScheduleByStatistics(@PathVariable long scheduleId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        StudyScheduleDTO statistics = studyScheduleService.findStudyScheduleByStatistics(scheduleId);

        if (statistics == null) {
            ResponseMessage responseMessage = new ResponseMessage(404, "조회 실패!", null);
            return new ResponseEntity<>(responseMessage, headers, HttpStatus.NOT_FOUND);
        }

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("statistics", statistics);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }
}
