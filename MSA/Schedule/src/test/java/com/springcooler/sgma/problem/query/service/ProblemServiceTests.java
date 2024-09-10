package com.springcooler.sgma.problem.query.service;

import com.springcooler.sgma.problem.query.dto.ProblemDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class ProblemServiceTests {

    @Autowired
    private ProblemService problemService;

    @DisplayName("전체 문제 조회")
    @Test
    void findAllProblems(){

        // given

        // when
        List<ProblemDTO> problems = problemService.findAllProblems();

        // then
        assertNotNull(problems);
        problems.forEach(x->log.info(x.toString()));
    }
}