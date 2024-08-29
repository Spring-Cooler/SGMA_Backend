package com.springcooler.sgma.problem.query.controller;

import com.springcooler.sgma.problem.query.common.ResponseMessage;
import com.springcooler.sgma.problem.query.dto.ProblemDTO;
import com.springcooler.sgma.problem.query.service.ProblemService;
import lombok.extern.slf4j.Slf4j;
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

@RestController("queryProblemController")
@RequestMapping("/api/problems")
@Slf4j
public class ProblemController {

    private ProblemService problemService;
    List<ProblemDTO> problems;
    @Autowired
    public ProblemController(ProblemService problemService, List<ProblemDTO> problems) {
        this.problemService = problemService;
        this.problems = problemService.findAllProblems();
    }
    @GetMapping("/")
    public ResponseEntity<ResponseMessage> findAllProblems() {
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
        Map<String,Object> responseMap = new HashMap<>();

        responseMap.put("problems",problems);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }


}
