package com.springcooler.sgma.studyschedule.command.application.service;

import com.springcooler.sgma.studyschedule.command.application.dto.StudyScheduleDTO;
import com.springcooler.sgma.studyschedule.command.domain.aggregate.StudySchedule;
import com.springcooler.sgma.studyschedule.command.domain.aggregate.StudyScheduleStatus;
import com.springcooler.sgma.studyschedule.command.domain.repository.StudyScheduleRepository;
import com.springcooler.sgma.studyschedule.command.domain.service.DomainStudyScheduleService;
import com.springcooler.sgma.studyscheduleparticipant.command.domain.aggregate.StudyScheduleParticipant;
import com.springcooler.sgma.studyscheduleparticipant.command.domain.repository.StudyScheduleParticipantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppStudyScheduleServiceImpl implements AppStudyScheduleService {
    private final ModelMapper modelMapper;
    private final DomainStudyScheduleService domainStudyScheduleService;
    private final StudyScheduleRepository studyScheduleRepository;
    private final StudyScheduleParticipantRepository participantRepository;

    @Autowired
    public AppStudyScheduleServiceImpl(ModelMapper modelMapper,
                                       DomainStudyScheduleService domainStudyScheduleService,
                                       StudyScheduleRepository studyScheduleRepository,
                                       StudyScheduleParticipantRepository participantRepository) {
        this.modelMapper = modelMapper;
        this.domainStudyScheduleService = domainStudyScheduleService;
        this.studyScheduleRepository = studyScheduleRepository;
        this.participantRepository = participantRepository;
    }

    // 스터디 일정 생성
    @Transactional
    @Override
    public StudySchedule registStudySchedule(StudyScheduleDTO createStudySchedule) {
        createStudySchedule.setActiveStatus(StudyScheduleStatus.ACTIVE.name());
        return studyScheduleRepository.save(modelMapper.map(createStudySchedule, StudySchedule.class));
    }

    // 스터디 일정 수정
    @Transactional
    @Override
    public StudySchedule modifyStudySchedule(Long scheduleId, StudyScheduleDTO updateStudySchedule) {
        StudySchedule existingSchedule = studyScheduleRepository
                .findById(scheduleId)
                .orElseThrow(() -> new EntityNotFoundException("잘못된 수정 요청입니다."));

        existingSchedule.setTitle(updateStudySchedule.getTitle());
        existingSchedule.setContent(updateStudySchedule.getContent());
        existingSchedule.setScheduleStartTime(updateStudySchedule.getScheduleStartTime());
        existingSchedule.setScheduleEndTime(updateStudySchedule.getScheduleEndTime());
        existingSchedule.setTestStatus(updateStudySchedule.getTestStatus());
        existingSchedule.setNumProblemsPerParticipant(updateStudySchedule.getNumProblemsPerParticipant());

        if ("N".equalsIgnoreCase(updateStudySchedule.getTestStatus())) {
            existingSchedule.setNumProblemsPerParticipant(0);
        }
        return studyScheduleRepository.save(existingSchedule);
    }

    // 스터디 일정 삭제
    @Transactional
    @Override
    public void deleteStudySchedule(long scheduleId) {
        StudySchedule deleteSchedule = studyScheduleRepository
                .findById(scheduleId)
                .orElseThrow(() -> new EntityNotFoundException("잘못된 삭제 요청입니다."));
        if (!domainStudyScheduleService.isActive(deleteSchedule.getActiveStatus())) {
            throw new EntityNotFoundException("잘못된 삭제 요청입니다.");
        }

        deleteSchedule.setActiveStatus(StudyScheduleStatus.INACTIVE.name());
        studyScheduleRepository.save(deleteSchedule);
    }

    // 일정에 따른 참가자들의 시험 평균 및 표준편차 계산 및 업데이트
    @Transactional
    @Override
    public void updateScheduleWithParticipantScores(Long scheduleId) {
        List<StudyScheduleParticipant> participants = participantRepository.findByScheduleId(scheduleId);

        List<Double> scores = participants.stream()
                .map(StudyScheduleParticipant::getTestScore)
                .collect(Collectors.toList());

        if (scores.isEmpty()) {
            throw new IllegalArgumentException("해당 일정에 등록된 참가자가 없습니다.");
        }

        double average = scores.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);

        double variance = scores.stream()
                .mapToDouble(score -> Math.pow(score - average, 2))
                .average()
                .orElse(0.0);
        double standardDeviation = Math.sqrt(variance);

        StudySchedule schedule = studyScheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 일정 ID입니다."));

        schedule.setTestAverage(average);
        schedule.setTestStandardDeviation(standardDeviation);
        studyScheduleRepository.save(schedule);
    }
}
