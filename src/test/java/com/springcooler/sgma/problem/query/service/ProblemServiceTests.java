package com.springcooler.sgma.problem.query.service;

import static org.junit.jupiter.api.Assertions.*;

import com.springcooler.sgma.problem.query.dto.ProblemDTO;
import com.springcooler.sgma.problem.query.service.ProblemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@SpringBootTest
@Transactional
class ProblemServiceTests {
    
    @Autowired
    private ProblemService problemService;

    @DisplayName("전체 문제 조회")
    @Test
    void testFindAllProblems(){
        List<ProblemDTO> problems = problemService.findAllProblmes();
        Assertions.assertNotNull(problems);
        problems.forEach(System.out::println);
    }

    @DisplayName("스케쥴 아이디로 문제 조회")
    @ParameterizedTest
    @ValueSource(longs=3L)
    void testFindProblemByScheduleId(long scheduleId) {
        List<ProblemDTO> problems = problemService.findProblemByScheduleId(scheduleId);
        Assertions.assertNotNull(problems);
        problems.forEach(System.out::println);
    }
}