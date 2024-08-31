package com.springcooler.sgma.problem.command.application.service;

import com.springcooler.sgma.problem.command.application.dto.ProblemDTO;
import com.springcooler.sgma.problem.command.domain.aggregate.Problem;
import jakarta.persistence.EntityNotFoundException;
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

    @DisplayName("문제 수정 테스트")
    @Test
    void testModifyProblem(){

        // given
        ProblemDTO problemDTO = new ProblemDTO();
        problemDTO.setProblemId(11);
        problemDTO.setAnswer(2);
        problemDTO.setParticipantId(1);
        problemDTO.setScheduleId(1);
        problemDTO.setContent("문제수정테스트");

        // when
        Problem problem = appProblemService.modifyProblem(problemDTO);

        // then
        assertNotNull(problem);
        System.out.println("problem : " + problem);
    }

    @DisplayName("문제 삭제 테스트")
    @Test
    void testDeleteProblem(){

        // given
        long deleteProblemId = 20L;
        
        // when
        appProblemService.deleteProblem(deleteProblemId);
        
        // then
        Assertions.assertThrows(EntityNotFoundException.class, ()-> appProblemService.deleteProblem(deleteProblemId));
        System.out.println("삭제 완료");
    }
}