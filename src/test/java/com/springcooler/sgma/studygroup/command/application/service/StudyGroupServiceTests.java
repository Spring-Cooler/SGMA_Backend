package com.springcooler.sgma.studygroup.command.application.service;

import com.springcooler.sgma.studygroup.command.application.dto.StudyGroupDTO;
import com.springcooler.sgma.studygroup.command.domain.aggregate.StudyGroup;
import com.springcooler.sgma.studygroup.command.domain.repository.StudyGroupRepository;
import com.springcooler.sgma.studygroupmember.command.application.dto.StudyGroupMemberDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class StudyGroupServiceTests {

    @Autowired
    private AppStudyGroupService studyGroupService;

    @Autowired
    private StudyGroupRepository studyGroupRepository;

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
            System.out.println(studyGroup);
        }

        //Then
        Assertions.assertNotNull(studyGroup);
    }

    @DisplayName("스터디 그룹 수정 테스트")
    @Test
    void testUpdateStudyGroup() {
        //Given
        StudyGroupDTO studyGroupInfo = new StudyGroupDTO();
        studyGroupInfo.setGroupId(1L);
        studyGroupInfo.setGroupName("반짝반짝");
        studyGroupInfo.setGroupMembers(5);
        studyGroupInfo.setUserId(1L);
        studyGroupInfo.setStudyGroupCategoryId(3);

        //When
        StudyGroup studyGroup = studyGroupService.modifyStudyGroup(studyGroupInfo);
        if (studyGroup != null) {
            System.out.println(studyGroup);
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
        System.out.println("DELETE SUCCESS");

        //Then
        String groupStatus = studyGroupRepository.findById(groupId).orElseThrow().getActiveStatus();
        Assertions.assertEquals("INACTIVE", groupStatus);
    }

    @DisplayName("스터디 그룹 참가 신청 승인 테스트")
    @Test
    void testAcceptApplication() {
        //Given
        StudyGroupMemberDTO applicant = new StudyGroupMemberDTO();
        applicant.setUserId(1L);
        applicant.setGroupId(5L);

        //When
        StudyGroup studyGroup = studyGroupService.acceptApplication(applicant);
        if (studyGroup != null) {
            System.out.println(studyGroup);
        }

        //Then
        Assertions.assertNotNull(studyGroup);
    }

    @DisplayName("스터디 그룹 탈퇴 테스트")
    @Test
    void testQuitStudyGroup() {
        //Given
        long memberId = 2L;
        long groupId = 1L;

        //When
        StudyGroup studyGroup = studyGroupService.quitStudyGroup(memberId, groupId);
        if (studyGroup != null) {
            System.out.println(studyGroup);
        }

        //Then
        Assertions.assertNotNull(studyGroup);
    }
}
