package com.springcooler.sgma.studygroup.query.service;

import com.springcooler.sgma.studygroup.query.dto.StudyGroupDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudyGroupServiceTests {
    @Autowired
    private StudyGroupService studyGroupService;

    @DisplayName("활성화된 스터디그룹 전체 조회 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"ACTIVE"})
    void testFindAllStudyGroupsByActiveStatus(String activeStatus) {
        Assertions.assertDoesNotThrow(
            () -> {
                List<StudyGroupDTO> studyGroups = studyGroupService.findAllStudyGroupsByActiveStatus(activeStatus);
                studyGroups.forEach(System.out::println);
            }
        );
    }
}
