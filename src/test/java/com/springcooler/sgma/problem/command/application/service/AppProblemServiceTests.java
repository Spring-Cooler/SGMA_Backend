package com.springcooler.sgma.problem.command.application.service;

import com.springcooler.sgma.problem.command.application.dto.ProblemDTO;
import com.springcooler.sgma.problem.command.domain.aggregate.Problem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@Transactional
class AppProblemServiceTests {

    @Autowired
    private AppProblemService appProblemService;

    @DisplayName("문제 생성 테스트")
    @Test
    void testRegistProblem(){
        // given
        ProblemDTO problemDTO = new ProblemDTO();
        problemDTO.setAnswer(1);
        problemDTO.setContent("문제생성테스트코드");
        problemDTO.setParticipantId(1L);
        problemDTO.setScheduleId(1L);
        // when

        Problem problem = appProblemService.registProblem(problemDTO);
        System.out.println("problem : " + problem);

        // then
        Assertions.assertNotNull(problem);
    }

}