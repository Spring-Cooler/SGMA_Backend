package com.springcooler.sgma.submittedanswer.command.application.controller;

import com.springcooler.sgma.submittedanswer.command.application.dto.SubmittedAnswerDTO;
import com.springcooler.sgma.submittedanswer.command.application.service.AppSubmittedAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController("commandSubmittedAnswerController")
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

    @PutMapping("/problems/{problemId}")
    public ResponseEntity<?> modifySubmittedAnswer(@RequestBody SubmittedAnswerDTO modifySubmittedAnswer){
        return ResponseEntity.created(URI.create("/api/submitted-answers/" + appSubmittedAnswerService.modifySubmittedAnswer(modifySubmittedAnswer))).build();
    }

}
