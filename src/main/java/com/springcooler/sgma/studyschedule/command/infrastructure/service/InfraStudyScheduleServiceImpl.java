package com.springcooler.sgma.studyschedule.command.infrastructure.service;

import com.springcooler.sgma.studyscheduleparticipant.command.application.dto.StudyScheduleParticipantDTO;
import com.springcooler.sgma.studyscheduleparticipant.command.application.service.AppStudyScheduleParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InfraStudyScheduleServiceImpl implements InfraStudyScheduleService {
    private final AppStudyScheduleParticipantService studyScheduleParticipantService;

    @Autowired
    public InfraStudyScheduleServiceImpl(AppStudyScheduleParticipantService studyScheduleParticipantService) {
        this.studyScheduleParticipantService = studyScheduleParticipantService;
    }

    // 스터디 일정 참가자 추가
    @Transactional
    @Override
    public void registStudyScheduleParticipant(StudyScheduleParticipantDTO newParticipant) {
        studyScheduleParticipantService.registStudyScheduleParticipant(newParticipant);
    }

    @Override
    public void deleteStudyScheduleParticipant(Long participantId) {
        studyScheduleParticipantService.deleteStudyScheduleParticipant(participantId);
    }
}
