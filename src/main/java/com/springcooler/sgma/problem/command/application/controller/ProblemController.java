package com.springcooler.sgma.problem.command.application.controller;

import com.springcooler.sgma.problem.command.application.dto.ProblemDTO;
import com.springcooler.sgma.problem.command.application.service.AppProblemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController("commandProblemController")
@RequestMapping("/api/study-problems")
@Slf4j
public class ProblemController {
    private final AppProblemService appProblemService;

    @Autowired
    public ProblemController(AppProblemService appProblemService) {
        this.appProblemService = appProblemService;
    }

    @PostMapping("/")
    public ResponseEntity<?> registProblem(@RequestBody ProblemDTO newProblem) {
        return ResponseEntity.created(URI.create("/api/study-problems" + appProblemService.registProblem(newProblem).getProblemId())).build();
    }

    @PostMapping("/modify")
    public ResponseEntity<?> modifyProblem(@RequestBody ProblemDTO modifiedProblem) {
        return ResponseEntity.created(URI.create("/api/study-problems/" + appProblemService.modifyProblem(modifiedProblem).getProblemId())).build();
    }
}
