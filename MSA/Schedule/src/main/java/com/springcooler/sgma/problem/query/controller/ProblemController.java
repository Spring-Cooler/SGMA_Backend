package com.springcooler.sgma.problem.query.controller;


import com.springcooler.sgma.problem.query.service.ProblemService;
import com.springcooler.sgma.problem.query.service.ProblemServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("queryProblemController")
@RequestMapping("/api/problems")
@Slf4j
public class ProblemController {

    private ProblemService problemService;
    @Autowired
    public ProblemController(ProblemServiceImpl queryProblemService) {
        this.problemService = queryProblemService;
    }




}
