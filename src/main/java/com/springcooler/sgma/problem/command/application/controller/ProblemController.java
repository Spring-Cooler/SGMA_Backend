package com.springcooler.sgma.problem.command.application.controller;

import com.springcooler.sgma.problem.command.application.dto.ProblemDTO;
import com.springcooler.sgma.problem.command.application.service.AppProblemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController("commandProblemController")
@RequestMapping("/api/problems")
@Slf4j
public class ProblemController {
    private final AppProblemService appProblemService;

    @Autowired
    public ProblemController(AppProblemService appProblemService) {
        this.appProblemService = appProblemService;
    }

    @PostMapping("/")
    public ResponseEntity<?> registProblem(@RequestBody ProblemDTO newProblem) {
        return ResponseEntity.created(URI.create("/api/problems" + appProblemService.registProblem(newProblem).getProblemId())).build();
    }

    @PutMapping("/modify")
    public ResponseEntity<?> modifyProblem(@RequestBody ProblemDTO modifiedProblem) {
        return ResponseEntity.created(URI.create("/api/problems/" + appProblemService.modifyProblem(modifiedProblem).getProblemId())).build();
    }

    @DeleteMapping("/{problemId}")
    public ResponseEntity<?> deleteProblem(@PathVariable("problemId") long problemId) {
        appProblemService.deleteProblem(problemId);

        return ResponseEntity.noContent().build();
    }
}
