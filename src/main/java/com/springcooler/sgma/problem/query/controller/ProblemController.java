package com.springcooler.sgma.problem.query.controller;

import com.springcooler.sgma.problem.query.common.ResponseMessage;
import com.springcooler.sgma.problem.query.dto.ProblemDTO;
import com.springcooler.sgma.problem.query.service.QueryProblemServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController("queryProblemController")
@RequestMapping("/api/problems")
@Slf4j
public class ProblemController {

    private QueryProblemServiceImpl queryProblemServiceImpl;
    List<ProblemDTO> problems;
    @Autowired
    public ProblemController(QueryProblemServiceImpl queryProblemServiceImpl, List<ProblemDTO> problems) {
        this.queryProblemServiceImpl = queryProblemServiceImpl;
        this.problems = queryProblemServiceImpl.findAllProblems();
    }
    @GetMapping("/")
    public ResponseEntity<ResponseMessage> getAllProblems() {
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
        Map<String,Object> responseMap = new HashMap<>();

        responseMap.put("problems",problems);

        ResponseMessage responseMessage = new ResponseMessage(200, "전체 문제 조회 성공", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("schedules/{scheduleId}")
    public ResponseEntity<ResponseMessage> getProblemsByScheduleId(@PathVariable("scheduleId") long scheduleId) {
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
        Map<String,Object> responseMap = new HashMap<>();
        List<ProblemDTO> problemsByScheduleId = problems.stream().filter(problem->problem.getScheduleId() == scheduleId).collect(Collectors.toList());
        responseMap.put("problemsByScheduleId",problemsByScheduleId);

        ResponseMessage responseMessage = new ResponseMessage(200,"스케쥴 아이디로 문제 조회 성공", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("schedules/{scheduleId}/participants/{participantId}")
    public ResponseEntity<ResponseMessage> getProblemsByParticipantIdAndScheduleId(@PathVariable("scheduleId") long scheduleId, @PathVariable("participantId") long participantId) {
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
        Map<String,Object> responseMap = new HashMap<>();
        List<ProblemDTO> problemsByParticipantIdAndScheduleId = problems.stream().filter(problem->(problem.getParticipantId() == participantId) && problem.getScheduleId()==scheduleId).collect(Collectors.toList());

        responseMap.put("problemsByParticipantIdAndScheduleId",problemsByParticipantIdAndScheduleId);

        ResponseMessage responseMessage = new ResponseMessage(200,"스케쥴 아이디와 참가자 아이디로 문제 조회 성공", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

}
