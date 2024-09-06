package com.springcooler.sgma.studygroupboard.query.service;

import com.springcooler.sgma.studygroupboard.query.dto.StudyGroupBoardDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class StudyGroupBoardServiceTests {

    @Autowired
    private StudyGroupBoardService studyGroupBoardService;

    @DisplayName("게시글 그룹별 조회 테스트")
    @ParameterizedTest
    @ValueSource(longs = 2L)
    void testFindStudyGroupBoardsByGroupId(Long groupId) {
        Assertions.assertDoesNotThrow(
                () -> {
                    List<StudyGroupBoardDTO> boards =
                            studyGroupBoardService.findStudyGroupBoardsByGroupId(groupId);
                    boards.forEach(x -> log.info(x.toString()));
                }
        );
    }

    @DisplayName("게시글 그룹원별 조회 테스트")
    @ParameterizedTest
    @ValueSource(longs = 1L)
    void testFindStudyGroupBoardsByMemberId(Long memberId) {
        Assertions.assertDoesNotThrow(
                () -> {
                    List<StudyGroupBoardDTO> boards =
                            studyGroupBoardService.findStudyGroupBoardsByMemberId(memberId);
                    boards.forEach(x -> log.info(x.toString()));
                }
        );
    }

    @DisplayName("게시글 그룹별 조회 테스트")
    @ParameterizedTest
    @ValueSource(strings = "험")
    void testFindStudyGroupBoardsByTitle(String title) {
        Assertions.assertDoesNotThrow(
                () -> {
                    List<StudyGroupBoardDTO> boards =
                            studyGroupBoardService.findStudyGroupBoardsByTitle(title);
                    boards.forEach(x -> log.info(x.toString()));
                }
        );
    }

    @DisplayName("게시글 그룹별 조회 테스트")
    @ParameterizedTest
    @ValueSource(longs = 3L)
    void testFindStudyGroupBoardByBoardId(Long boardId) {
        Assertions.assertDoesNotThrow(
                () -> {
                    StudyGroupBoardDTO board = studyGroupBoardService.findStudyGroupBoardByBoardId(boardId);
                    log.info(board.toString());
                }
        );
    }

}
