package com.springcooler.sgma.studygroupnotice.query.service;

import com.springcooler.sgma.studygroupnotice.query.dto.StudyGroupNoticeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudyGroupNoticeServiceTests {

    @Autowired
    private StudyGroupNoticeService studyGroupNoticeService;

    @DisplayName("스터디그룹 공지사항 전체 조회(스터디그룹 아이디) 테스트")
    @ParameterizedTest
    @ValueSource(longs = 1L)
    void testFindStudyGroupNoticesByGroupId(long groupId) {
        Assertions.assertDoesNotThrow(
                () -> {
                    List<StudyGroupNoticeDTO> studyGroupNotices =
                            studyGroupNoticeService.findStudyGroupNoticesByGroupId(groupId);
                    studyGroupNotices.forEach(System.out::println);
                }
        );
    }

    @DisplayName("스터디그룹 공지사항 단건 조회(공지사항 아이디) 테스트")
    @ParameterizedTest
    @ValueSource(longs = 2L)
    void testFindStudyGroupNoticeByNoticeId(long noticeId) {
        Assertions.assertDoesNotThrow(
                () -> {
                    List<StudyGroupNoticeDTO> studyGroupNotice =
                            studyGroupNoticeService.findStudyGroupNoticeByNoticeId(noticeId);
                    studyGroupNotice.forEach(System.out::println);
                }
        );
    }
}
