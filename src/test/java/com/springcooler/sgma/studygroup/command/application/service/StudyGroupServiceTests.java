package com.springcooler.sgma.studygroup.command.application.service;

import com.springcooler.sgma.studygroup.command.application.dto.StudyGroupDTO;
import com.springcooler.sgma.studygroup.command.domain.aggregate.StudyGroup;
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
    private StudyGroupService studyGroupService;

    @DisplayName("스터디 그룹 생성 테스트")
    @Test
    void testSaveStudyGroup() {
        //Given
        StudyGroupDTO studyGroupInfo = new StudyGroupDTO();
        studyGroupInfo.setGroupName("메가스터디");
        studyGroupInfo.setActiveStatus("ACTIVE");
        studyGroupInfo.setGroupMembers(1);
        studyGroupInfo.setUserId(5);
        studyGroupInfo.setStudyGroupCategoryId(7);

        //When
        StudyGroup studyGroup = studyGroupService.registStudyGroup(studyGroupInfo);

        //Then
        Assertions.assertDoesNotThrow(() -> System.out.println(studyGroup));
    }

    @DisplayName("스터디 그룹 수정 테스트")
    @Test
    void testUpdateStudyGroup() {
        //Given
        StudyGroupDTO studyGroupInfo = new StudyGroupDTO();
        studyGroupInfo.setGroupId(1L);
        studyGroupInfo.setGroupName("반짝반짝");
        studyGroupInfo.setActiveStatus("ACTIVE");
        studyGroupInfo.setGroupMembers(5);
        studyGroupInfo.setUserId(1);
        studyGroupInfo.setStudyGroupCategoryId(3);

        //When
        StudyGroup studyGroup = studyGroupService.modifyStudyGroup(studyGroupInfo);

        //Then
        Assertions.assertDoesNotThrow(() -> System.out.println(studyGroup));
    }
}
