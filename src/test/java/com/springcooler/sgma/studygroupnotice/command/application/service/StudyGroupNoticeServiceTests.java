package com.springcooler.sgma.studygroupnotice.command.application.service;

import com.springcooler.sgma.studygroupnotice.command.application.dto.StudyGroupNoticeDTO;
import com.springcooler.sgma.studygroupnotice.command.domain.aggregate.StudyGroupNotice;
import com.springcooler.sgma.studygroupnotice.common.exception.CommonException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class StudyGroupNoticeServiceTests {

    @Autowired
    private AppStudyGroupNoticeService studyGroupNoticeService;

    @DisplayName("스터디그룹 공지사항 생성 테스트")
    @Test
    void testRegistStudyGroupNotice() {
        //Given
        StudyGroupNoticeDTO newNotice = new StudyGroupNoticeDTO();
        newNotice.setTitle("테스트용 제목");
        newNotice.setContent("테스트용 내용");
        newNotice.setGroupId(1L);

        //When
        StudyGroupNotice notice = studyGroupNoticeService.registStudyGroupNotice(newNotice);
        if (notice != null) {
            System.out.println(notice);
        }

        //Then
        Assertions.assertNotNull(notice);
    }

    @DisplayName("스터디그룹 공지사항 정보 수정 테스트")
    @Test
    void testModifyStudyGroupNotice() {
        //Given
        StudyGroupNoticeDTO modifyNotice = new StudyGroupNoticeDTO();
        modifyNotice.setNoticeId(1L);
        modifyNotice.setTitle("바뀐 제목");
        modifyNotice.setContent("바뀐 내용");

        //When
        StudyGroupNotice notice = studyGroupNoticeService.modifyStudyGroupNotice(modifyNotice);
        if (notice != null) {
            System.out.println(notice);
        }

        //Then
        Assertions.assertNotNull(notice);
    }

    @DisplayName("스터디그룹 공지사항 삭제 테스트")
    @Test
    void testDeleteStudyGroupNotice() {
        //Given
        long noticeId = 1L;

        //When
        studyGroupNoticeService.deleteStudyGroupNotice(noticeId);
        System.out.println("DELETE SUCCESS");

        //Then
        Assertions.assertThrows(CommonException.class,
                () -> studyGroupNoticeService.deleteStudyGroupNotice(noticeId));
    }
}
