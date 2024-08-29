package com.springcooler.sgma.studygroupmember.query.service;

import com.springcooler.sgma.studygroupmember.query.dto.StudyGroupMemberDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudyGroupMemberServiceTests {

    @Autowired
    StudyGroupMemberService studyGroupMemberService;

    @DisplayName("스터디 그룹원 단건 조회(그룹원 아이디) 테스트")
    @ParameterizedTest
    @ValueSource(longs = 6)
    void testFindStudyGroupMemberByMemberId(long memberId) {
        Assertions.assertDoesNotThrow(
                () -> {
                    List<StudyGroupMemberDTO> studyGroupMembers
                            = studyGroupMemberService.findStudyGroupMemberByMemberId(memberId);
                    studyGroupMembers.forEach(System.out::println);
                }
        );
    }

    @DisplayName("스터디 그룹원 그룹별 조회 테스트")
    @ParameterizedTest
    @ValueSource(longs = 4)
    void testFindStudyGroupMembersByGroupId(long groupId) {
        Assertions.assertDoesNotThrow(
                () -> {
                    List<StudyGroupMemberDTO> studyGroupMembers
                            = studyGroupMemberService.findStudyGroupMembersByGroupId(groupId);
                    studyGroupMembers.forEach(System.out::println);
                }
        );
    }

}