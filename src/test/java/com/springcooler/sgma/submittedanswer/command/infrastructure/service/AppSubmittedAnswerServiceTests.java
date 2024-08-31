package com.springcooler.sgma.submittedanswer.command.infrastructure.service;

import com.springcooler.sgma.submittedanswer.command.application.dto.SubmittedAnswerDTO;
import com.springcooler.sgma.submittedanswer.command.application.service.AppSubmittedAnswerService;
import com.springcooler.sgma.submittedanswer.command.domain.aggregate.SubmittedAnswer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class AppSubmittedAnswerServiceTests {
    @Autowired
    private AppSubmittedAnswerService appSubmittedAnswerService;

    @DisplayName("문제에 대한 답안 제출 및 채점 테스트")
    @Test
    void testRegistSubmittedAnswer(){

        // given
        SubmittedAnswerDTO newSubmittedAnswerDTO = new SubmittedAnswerDTO(1,1,3, null);
        log.info("newSubmittedAnswerDTO: {}", newSubmittedAnswerDTO);
        // when
        SubmittedAnswer newSubmittedAnswer = appSubmittedAnswerService.registSubmittedAnswer(newSubmittedAnswerDTO);

        // then
        assertNotNull(newSubmittedAnswer);
        log.info("newSubmittedAnswer: {}", newSubmittedAnswer);
    }



}