package com.springcooler.sgma.studyscheduleparticipant.command.application.service;

import com.springcooler.sgma.studyscheduleparticipant.command.application.dto.StudyScheduleParticipantDTO;
import com.springcooler.sgma.studyschedule.command.domain.aggregate.StudySchedule;
import com.springcooler.sgma.studyscheduleparticipant.command.domain.aggregate.StudyScheduleParticipant;
import com.springcooler.sgma.studyscheduleparticipant.command.domain.repository.StudyScheduleParticipantRepository;
import com.springcooler.sgma.studyschedule.command.domain.repository.StudyScheduleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppStudyScheduleParticipantServiceImpl implements AppStudyScheduleParticipantService {

    private final StudyScheduleParticipantRepository participantRepository;
    private final StudyScheduleRepository scheduleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AppStudyScheduleParticipantServiceImpl(StudyScheduleParticipantRepository participantRepository,
                                                  StudyScheduleRepository scheduleRepository,
                                                  ModelMapper modelMapper) {
        this.participantRepository = participantRepository;
        this.scheduleRepository = scheduleRepository;
        this.modelMapper = modelMapper;
    }

    // 스터디 그룹 일정 참가
    @Transactional
    @Override
    public StudySchedule registStudyScheduleParticipant(StudyScheduleParticipantDTO newParticipant) {
        if (newParticipant.getSubmissionStatus() == null) {
            newParticipant.setSubmissionStatus("N");
        }
        if (newParticipant.getNumSubmittedProblems() == null) {
            newParticipant.setNumSubmittedProblems(0);
        }
        if (newParticipant.getTestScore() == null) {
            newParticipant.setTestScore(0.0);
        }
        if (newParticipant.getTestPercentage() == null) {
            newParticipant.setTestPercentage(0.0);
        }

        StudySchedule schedule = scheduleRepository.findById(newParticipant.getScheduleId())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 일정 ID입니다."));

        StudyScheduleParticipant participant = modelMapper.map(newParticipant, StudyScheduleParticipant.class);
        participantRepository.save(participant);

        schedule.setNumParticipants(schedule.getNumParticipants() + 1);
        return scheduleRepository.save(schedule);
    }

    // 스터디 그룹 일정 참가 취소
    @Transactional
    @Override
    public void deleteStudyScheduleParticipant(Long participantId) {
        StudyScheduleParticipant existingParticipant = participantRepository.findById(participantId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 참가자 ID입니다."));

        StudySchedule schedule = scheduleRepository.findById(existingParticipant.getScheduleId())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 일정 ID입니다."));

        participantRepository.delete(existingParticipant);

        schedule.setNumParticipants(schedule.getNumParticipants() - 1);
        scheduleRepository.save(schedule);
    }
}
