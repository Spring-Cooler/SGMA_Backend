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

        // 중복 참가자 여부 확인
        if (participantRepository.existsByScheduleIdAndMemberId(newParticipant.getScheduleId(), newParticipant.getMemberId())) {
            throw new IllegalArgumentException("이 멤버는 이미 해당 일정에 참가자로 등록되어 있습니다.");
        }

        StudyScheduleParticipant participant = modelMapper.map(newParticipant, StudyScheduleParticipant.class);
        participantRepository.save(participant);

        schedule.setNumParticipants(schedule.getNumParticipants() + 1);
        return scheduleRepository.save(schedule);
    }

    // 스터디 그룹 일정 참가 취소
    @Transactional
    @Override
    public void deleteStudyScheduleParticipant(Long scheduleId, Long memberId) {
        StudySchedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 일정 ID입니다."));

        StudyScheduleParticipant participant = participantRepository
                .findByScheduleIdAndMemberId(scheduleId, memberId)
                .orElseThrow(() -> new IllegalArgumentException("참가자가 이 일정에 등록되어 있지 않습니다."));

        participantRepository.delete(participant);

        schedule.setNumParticipants(schedule.getNumParticipants() - 1);
        scheduleRepository.save(schedule);
    }
}
