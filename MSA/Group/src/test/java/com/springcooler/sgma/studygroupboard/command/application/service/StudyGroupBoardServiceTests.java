package com.springcooler.sgma.studygroupboard.command.application.service;

import com.springcooler.sgma.studygroupboard.command.application.dto.StudyGroupBoardDTO;
import com.springcooler.sgma.studygroupboard.common.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@SpringBootTest
class StudyGroupBoardServiceTests {

    @Autowired
    private AppStudyGroupBoardService studyGroupBoardService;

    @DisplayName("스터디그룹 자유게시글 작성 테스트")
    @Test
    void testRegistStudyGroupBoard() {
        //Given
        StudyGroupBoardDTO newBoard = StudyGroupBoardDTO.builder()
                .title("테스트용 제목")
                .content("테스트용 내용")
                .memberId(1L)
                .groupId(1L)
                .build();

        //When
        StudyGroupBoardDTO board = studyGroupBoardService.registStudyGroupBoard(newBoard);

        if (board != null) {
            log.info(board.toString());
        }

        //Then
        Assertions.assertNotNull(board);
    }

    @DisplayName("스터디그룹 자유게시글 수정 테스트")
    @Test
    void testModifyStudyGroupBoard() {
        //Given
        StudyGroupBoardDTO modifyBoard = StudyGroupBoardDTO.builder()
                .studyGroupBoardId(1L)
                .title("바뀐 제목")
                .content("바뀐 내용")
                .build();

        //When
        StudyGroupBoardDTO board = studyGroupBoardService.modifyStudyGroupBoard(modifyBoard);
        if (board != null) {
            log.info(board.toString());
        }

        //Then
        Assertions.assertNotNull(board);
    }

    @DisplayName("스터디그룹 자유게시글 삭제 테스트")
    @Test
    void testDeleteStudyGroupBoard() {
        //Given
        Long boardId = 1L;

        //When
        studyGroupBoardService.deleteStudyGroupBoard(boardId);

        //Then
        Assertions.assertThrows(CommonException.class,
                () -> studyGroupBoardService.deleteStudyGroupBoard(boardId));
    }

}
