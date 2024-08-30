package com.springcooler.sgma.studygroupnotice.command.application.service;

import com.springcooler.sgma.studygroupnotice.command.application.dto.StudyGroupNoticeDTO;
import com.springcooler.sgma.studygroupnotice.command.domain.aggregate.StudyGroupNotice;
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
}
