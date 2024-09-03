package com.springcooler.sgma.studygroup.command.application.service;

import com.springcooler.sgma.studygroup.command.application.dto.StudyGroupDTO;
import com.springcooler.sgma.studygroup.command.domain.aggregate.StudyGroup;
import com.springcooler.sgma.studygroup.common.exception.CommonException;
import com.springcooler.sgma.studygroupmember.command.application.dto.StudyGroupMemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
@Transactional
class StudyGroupServiceTests {

    @Autowired
    private AppStudyGroupService studyGroupService;

    @DisplayName("스터디 그룹 생성 테스트")
    @Test
    void testSaveStudyGroup() {
        //Given
        StudyGroupDTO studyGroupInfo = new StudyGroupDTO();
        studyGroupInfo.setGroupName("메가스터디");
        studyGroupInfo.setUserId(5L);
        studyGroupInfo.setStudyGroupCategoryId(7);

        //When
        StudyGroup studyGroup = studyGroupService.registStudyGroup(studyGroupInfo);

        if (studyGroup != null) {
            log.info(studyGroup.toString());
        }

        //Then
        Assertions.assertNotNull(studyGroup);
    }

    @DisplayName("스터디 그룹 수정 테스트")
    @Test
    void testModifyStudyGroup() {
        //Given
        StudyGroupDTO studyGroupInfo = new StudyGroupDTO();
        studyGroupInfo.setGroupId(1L);
        studyGroupInfo.setGroupName("반짝반짝");
        studyGroupInfo.setStudyGroupCategoryId(3);

        //When
        StudyGroup studyGroup = studyGroupService.modifyStudyGroup(studyGroupInfo);
        if (studyGroup != null) {
            log.info(studyGroup.toString());
        }

        //Then
        Assertions.assertNotNull(studyGroup);
    }

    @DisplayName("스터디 그룹 이름 변경 테스트")
    @Test
    void testModifyStudyGroupName() {
        //Given
        StudyGroupDTO studyGroupInfo = new StudyGroupDTO();
        studyGroupInfo.setGroupId(5L);
        studyGroupInfo.setGroupName("나만의스터디");

        //When
        StudyGroup studyGroup = studyGroupService.modifyStudyGroupName(studyGroupInfo);
        if (studyGroup != null) {
            log.info(studyGroup.toString());
        }

        //Then
        Assertions.assertNotNull(studyGroup);
    }

    @DisplayName("스터디 그룹 카테고리 변경 테스트")
    @Test
    void testModifyStudyGroupCategory() {
        //Given
        StudyGroupDTO studyGroupInfo = new StudyGroupDTO();
        studyGroupInfo.setGroupId(5L);
        studyGroupInfo.setStudyGroupCategoryId(8);

        //When
        StudyGroup studyGroup = studyGroupService.modifyStudyGroupCategory(studyGroupInfo);
        if (studyGroup != null) {
            log.info(studyGroup.toString());
        }

        //Then
        Assertions.assertNotNull(studyGroup);
    }

    @DisplayName("스터디 그룹 삭제 테스트")
    @Test
    void testDeleteStudyGroup() {
        //Given
        long groupId = 2L;

        //When
        studyGroupService.deleteStudyGroup(groupId);
        log.info("DELETE SUCCESS");

        //Then
        Assertions.assertThrows(CommonException.class,
                () -> studyGroupService.deleteStudyGroup(groupId));
    }

    @DisplayName("스터디 그룹 참가 신청 승인 테스트")
    @Test
    void testAcceptApplication() {
        //Given
        StudyGroupMemberDTO applicant = new StudyGroupMemberDTO();
        applicant.setUserId(1L);
        applicant.setGroupId(5L);
        int expectedMembers = 4;

        //When
        StudyGroup studyGroup = studyGroupService.registAcceptedMember(applicant);
        if (studyGroup != null) {
            log.info(studyGroup.toString());
        }

        //Then
        Assertions.assertNotNull(studyGroup);
        Assertions.assertEquals(expectedMembers, studyGroup.getGroupMembers());
    }

    @DisplayName("스터디 그룹 탈퇴 테스트")
    @Test
    void testQuitStudyGroup() {
        //Given
        long memberId = 2L;
        long groupId = 1L;
        int expectedMembers = 2;

        //When
        StudyGroup studyGroup = studyGroupService.deleteQuitMember(memberId, groupId);
        if (studyGroup != null) {
            log.info(studyGroup.toString());
        }

        //Then
        Assertions.assertNotNull(studyGroup);
        Assertions.assertEquals(expectedMembers, studyGroup.getGroupMembers());
    }
}
