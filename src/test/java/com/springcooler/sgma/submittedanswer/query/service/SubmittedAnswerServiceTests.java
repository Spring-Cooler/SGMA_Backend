package com.springcooler.sgma.submittedanswer.query.service;

import com.springcooler.sgma.submittedanswer.query.dto.SubmittedAnswerDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubmittedAnswerServiceTests {
    @Autowired
    private SubmittedAnswerService submittedAnswerService;

    @DisplayName("제출 답안 전체 조회 테스트")
    @Test
    void testFindAllSubmittedAnswers(){

        // given

        // when
        List<SubmittedAnswerDTO> submittedAnswers = submittedAnswerService.findAllSubmittedAnswers();
        // then
        assertNotNull(submittedAnswers);
        submittedAnswers.forEach(System.out::println);
    }
}