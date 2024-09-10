package com.springcooler.sgma.submittedanswer.query.controller;

import com.springcooler.sgma.submittedanswer.common.ResponseDTO;
import com.springcooler.sgma.submittedanswer.query.dto.SubmittedAnswerDTO;
import com.springcooler.sgma.submittedanswer.query.service.SubmittedAnswerService;
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

@RestController("submittedAnswerController")
@RequestMapping("/api/submitted-answers")
public class SubmittedAnswerController {

    SubmittedAnswerService submittedAnswerService;
    @Autowired
    public SubmittedAnswerController(SubmittedAnswerService submittedAnswerService) {
        this.submittedAnswerService = submittedAnswerService;
    }
    @GetMapping("/")
    public ResponseDTO<?> getAllSubmittedAnswers() {
        return ResponseDTO.ok(submittedAnswerService.findAllSubmittedAnswers());

    }

    @GetMapping("/problems/{problemId}")
    public ResponseDTO<?> getSubmittedAnswersByProblemId(@PathVariable("problemId") long problemId){
        return ResponseDTO.ok(submittedAnswerService.findSubmittedAnswersByProblemId(problemId));
    }



}
