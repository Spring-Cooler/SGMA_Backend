package com.springcooler.sgma.problem.command.application.controller;

import com.springcooler.sgma.problem.command.application.dto.ProblemDTO;
import com.springcooler.sgma.problem.command.application.service.AppProblemService;
import com.springcooler.sgma.problem.command.domain.aggregate.entity.Problem;
import com.springcooler.sgma.problem.common.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseDTO<?> registProblem(@RequestBody ProblemDTO newProblem) {
            Problem problem = appProblemService.registProblem(newProblem);
            return ResponseDTO.ok(problem);
    }

    @PutMapping("/modify")
    public ResponseDTO<?> modifyProblem(@RequestBody ProblemDTO modifiedProblem) {
        Problem problem = appProblemService.modifyProblem(modifiedProblem);
        return ResponseDTO.ok(problem);
    }

    @DeleteMapping("/{problemId}")
    public ResponseDTO<?> deleteProblem(@PathVariable("problemId") long problemId) {
        appProblemService.deleteProblem(problemId);

        return ResponseDTO.ok(null);
    }
}
