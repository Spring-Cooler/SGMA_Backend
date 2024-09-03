package com.springcooler.sgma.studyScheduleParticipant.command.application.service;

import com.springcooler.sgma.studyschedule.command.domain.aggregate.StudySchedule;
import com.springcooler.sgma.studyscheduleparticipant.command.application.dto.StudyScheduleParticipantDTO;
import com.springcooler.sgma.studyscheduleparticipant.command.application.service.AppStudyScheduleParticipantService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class StudyScheduleParticipantServiceTests {

    @Autowired
    private AppStudyScheduleParticipantService studyScheduleParticipantService;

    @DisplayName("스터디 그룹 일정 참가자 등록 테스트")
    @Test
    void testRegisterParticipant() {
        // Given
        StudyScheduleParticipantDTO newParticipant = new StudyScheduleParticipantDTO();

        StudySchedule participant = studyScheduleParticipantService.registStudyScheduleParticipant(newParticipant);
        if (participant != null) {
            System.out.println(participant);
        }

        Assertions.assertNotNull(participant);
    }

    @DisplayName("스터디 그룹 일정 참가자 삭제 테스트")
    @Test
    void testDeleteParticipant() {
        // Given
        long scheduleId = 1L;
        long memberId = 1L;

        // When
        studyScheduleParticipantService.deleteStudyScheduleParticipant(scheduleId, memberId);
        System.out.println("DELETE SUCCESS");

        // Then
        Assertions.assertThrows(EntityNotFoundException.class,
                () -> studyScheduleParticipantService.deleteStudyScheduleParticipant(scheduleId, memberId));
    }
}