package com.springcooler.sgma.submittedanswer.command.application.controller;

import com.springcooler.sgma.submittedanswer.command.application.dto.SubmittedAnswerDTO;
import com.springcooler.sgma.submittedanswer.command.infrastructure.service.AppSubmittedAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController("appSubmittedAnswerController")
@RequestMapping("/api/submitted-answers/")
public class SubmittedAnswerController {

    AppSubmittedAnswerService appSubmittedAnswerService;

    @Autowired
    public SubmittedAnswerController(AppSubmittedAnswerService appSubmittedAnswerService) {
        this.appSubmittedAnswerService = appSubmittedAnswerService;
    }

    @PostMapping("/")
    public ResponseEntity<?> registSubmittedAnswer(@RequestBody SubmittedAnswerDTO newSubmittedAnswer){
        return ResponseEntity.created(URI.create("/api/submitted-answers/" + appSubmittedAnswerService.registSubmittedAnswer(newSubmittedAnswer))).build();
    }

}
