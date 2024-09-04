package com.springcooler.sgma.submittedanswer.command.application.controller;

import com.springcooler.sgma.submittedanswer.command.application.dto.SubmittedAnswerDTO;
import com.springcooler.sgma.submittedanswer.command.application.service.AppSubmittedAnswerService;
import com.springcooler.sgma.submittedanswer.common.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController("commandSubmittedAnswerController")
@RequestMapping("/api/submitted-answers/")
public class SubmittedAnswerController {

    AppSubmittedAnswerService appSubmittedAnswerService;

    @Autowired
    public SubmittedAnswerController(AppSubmittedAnswerService appSubmittedAnswerService) {
        this.appSubmittedAnswerService = appSubmittedAnswerService;
    }

    @PostMapping("/")
    public ResponseDTO<?> registSubmittedAnswer(@RequestBody SubmittedAnswerDTO newSubmittedAnswer){
        return ResponseDTO.ok(appSubmittedAnswerService.registSubmittedAnswer(newSubmittedAnswer));
    }

    @PutMapping("/")
    public ResponseDTO<?> modifySubmittedAnswer(@RequestBody SubmittedAnswerDTO modifySubmittedAnswer){
        return ResponseDTO.ok(appSubmittedAnswerService.modifySubmittedAnswer(modifySubmittedAnswer));
    }
<<<<<<< HEAD
    @PutMapping("/grade/{participantId}")
    public ResponseDTO<?> gradeSubmittedAnswerByParticipantId(@PathVariable long participantId){
        appSubmittedAnswerService.gradeSubmittedAnswersByParticipantId(participantId);
        return ResponseDTO.ok(null);
=======

    @PutMapping("/grade/{scheduleId}/{participantId}")
    public ResponseDTO<?> gradeSubmittedAnswerByParticipantId(@PathVariable long scheduleId, @PathVariable long participantId){
        return ResponseDTO.ok(String.valueOf(appSubmittedAnswerService.gradeSubmittedAnswersByParticipantId(scheduleId, participantId)));
    }

>>>>>>> 0f6c58feede98b581129115d6b402051ada28868
    }
//    @PutMapping("/grade/")// TODO: 시험 종료시 해당 시험에 해당하는 문제 한번에 채점
//    public ResponseEntity<?> gradeSubmittedAnswer(@RequestBody SubmittedAnswerDTO answerToGrade){
//
//        return ResponseEntity.created(URI.create("/api/submitted-answers/grade/" + appSubmittedAnswerService.gradeSubmittedAnswer(answerToGrade).getAnswerStatus())).build();
//    }



