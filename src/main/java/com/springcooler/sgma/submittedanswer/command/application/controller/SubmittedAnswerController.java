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
        return ResponseEntity.created(URI.create("/api/submitted-answers/" + appSubmittedAnswerService.registSubmittedAnswer(newSubmittedAnswer).getAnswerStatus())).build();
    }

    @PutMapping("/")
    public ResponseEntity<?> modifySubmittedAnswer(@RequestBody SubmittedAnswerDTO modifySubmittedAnswer){
        return ResponseEntity.created(URI.create("/api/submitted-answers/" + appSubmittedAnswerService.modifySubmittedAnswer(modifySubmittedAnswer).getAnswerStatus())).build();
    }

//    @PutMapping("/grade/")// TODO: 시험 종료시 해당 시험에 해당하는 문제 한번에 채점
//    public ResponseEntity<?> gradeSubmittedAnswer(@RequestBody SubmittedAnswerDTO answerToGrade){
//
//        return ResponseEntity.created(URI.create("/api/submitted-answers/grade/" + appSubmittedAnswerService.gradeSubmittedAnswer(answerToGrade).getAnswerStatus())).build();
//    }


}
