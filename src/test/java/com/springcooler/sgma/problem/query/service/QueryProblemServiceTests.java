package com.springcooler.sgma.problem.query.service;

import com.springcooler.sgma.problem.query.dto.ProblemDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
@Transactional
class QueryProblemServiceTests {

    @Autowired
    private QueryProblemService queryProblemService;

    @DisplayName("전체 문제 조회")
    @Test
    void testFindAllProblems() {
        List<ProblemDTO> problems = queryProblemService.findAllProblems();
        Assertions.assertNotNull(problems);
        problems.forEach(System.out::println);
    }

    @DisplayName("스케쥴 아이디로 문제 조회")
    @ParameterizedTest
    @ValueSource(longs = 3L)
    void testFindProblemsByScheduleId(long scheduleId) {
        List<ProblemDTO> problems = queryProblemService.findProblemsByScheduleId(scheduleId);
        Assertions.assertNotNull(problems);
        problems.forEach(System.out::println);
    }

    private static Stream<Arguments> getParticipantAndScheduleInfo(){
        return Stream.of(
                Arguments.of(1,3)
        );
    }
    @DisplayName("참가자 아이디와 스케쥴 아이디로 문제 조회")
    @ParameterizedTest
    @MethodSource("getParticipantAndScheduleInfo")
    void testFindProblemsByParticipantIdAndScheduleId(long participantId, long scheduleId) {
        List<ProblemDTO> problems = queryProblemService.findProblemsByParticipantIdAndScheduleId(participantId, scheduleId);
    }
}