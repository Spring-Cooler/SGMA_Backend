package com.springcooler.sgma.problem.command.application.service;

import com.springcooler.sgma.problem.command.application.dto.ProblemAndChoiceDTO;
import com.springcooler.sgma.problem.command.application.dto.ProblemDTO;
import com.springcooler.sgma.problem.command.domain.aggregate.entity.Problem;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@Transactional
    @Slf4j
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
        long deleteProblemId = 11L;
        
        // when
        appProblemService.deleteProblem(deleteProblemId);
        
        // then
        Assertions.assertThrows(EntityNotFoundException.class, ()-> appProblemService.deleteProblem(deleteProblemId));
        System.out.println("삭제 완료");
    }

    @DisplayName("문제 및 선지 등록 테스트")
    @Test
    void testRegistProblemAndChoices(){

        // given
        long participantId = 1L;
        long scheduleId = 1L;
        String content = "문제 및 선지 등록 테스트";
        int answer = 1;
        String[] choices = {"1","2","3","4"};
        ProblemAndChoiceDTO problemAndChoiceDTO = new ProblemAndChoiceDTO(participantId, scheduleId, content, answer, choices);

        // when
        Map<String, Object> result = appProblemService.registProblemAndChoice(problemAndChoiceDTO);

        // then
        assertNotNull(result);
        log.info("result.get(registeredProblem): {}", result.get("registeredproblem"));
        log.info("result.get(numInsertedChoices): {}", result.get("numInsertedChoices"));
    }
}