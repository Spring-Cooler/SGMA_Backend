package com.springcooler.sgma.studyschedule.command.infrastructure.service;

import com.springcooler.sgma.studyscheduleparticipant.command.application.dto.StudyScheduleParticipantDTO;

public interface InfraStudyScheduleService {

    // 스터디 일정 참가자 추가
    void registStudyScheduleParticipant(StudyScheduleParticipantDTO newParticipant);

    void deleteStudyScheduleParticipant(Long participantId);
}
