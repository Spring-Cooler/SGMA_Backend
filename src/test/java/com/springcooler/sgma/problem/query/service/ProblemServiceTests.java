package com.springcooler.sgma.problem.query.service;

import static org.junit.jupiter.api.Assertions.*;

import com.springcooler.sgma.problem.query.dto.ProblemDTO;
import com.springcooler.sgma.problem.query.service.ProblemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        Assertions.assertDoesNotThrow(
                ()->{
                    List<ProblemDTO> problems = problemService.findAllProblmes();
                    problems.forEach(System.out::println);
                }
        );
    }
}