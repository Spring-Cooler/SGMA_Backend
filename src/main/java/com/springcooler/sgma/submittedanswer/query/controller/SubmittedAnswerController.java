package com.springcooler.sgma.submittedanswer.query.controller;

import com.springcooler.sgma.problem.query.common.ResponseMessage;
import com.springcooler.sgma.problem.query.dto.ProblemDTO;
import com.springcooler.sgma.submittedanswer.query.dto.SubmittedAnswerDTO;
import com.springcooler.sgma.submittedanswer.query.service.SubmittedAnswerService;
import org.apache.tomcat.util.digester.DocumentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("sumittedAnswerController")
@RequestMapping("/api/submitted-answers")
public class SubmittedAnswerController {

    SubmittedAnswerService submittedAnswerService;
//    List<SubmittedAnswerDTO> submittedAnswerDTOs;

    @Autowired
    public SubmittedAnswerController(SubmittedAnswerService submittedAnswerService) {
        this.submittedAnswerService = submittedAnswerService;
//        this.submittedAnswerDTOs = submittedAnswerService.findAllSubmittedAnswers();
    }
    @GetMapping("/")
    public ResponseEntity<ResponseMessage> getAllSubmittedAnswers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();
        List<SubmittedAnswerDTO> submittedAnswers = submittedAnswerService.findAllSubmittedAnswers();
        responseMap.put("submittedAnswers", submittedAnswers);

        ResponseMessage responseMessage = new ResponseMessage(200,"전체 제출답안 조회 완료", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }
}
