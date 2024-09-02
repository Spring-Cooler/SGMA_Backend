package com.springcooler.sgma.studyschedule.command.application.service;

import com.springcooler.sgma.studyschedule.command.application.dto.StudyScheduleDTO;
import com.springcooler.sgma.studyschedule.command.domain.aggregate.StudySchedule;
import com.springcooler.sgma.studyschedule.command.domain.aggregate.StudyScheduleStatus;
import com.springcooler.sgma.studyschedule.command.domain.repository.StudyScheduleRepository;
import com.springcooler.sgma.studyschedule.command.domain.service.DomainStudyScheduleService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppStudyScheduleServiceImpl implements AppStudyScheduleService {
    private final ModelMapper modelMapper;
    private final DomainStudyScheduleService domainStudyScheduleService;
    private final StudyScheduleRepository studyScheduleRepository;

    public AppStudyScheduleServiceImpl(ModelMapper modelMapper,
                                       DomainStudyScheduleService domainStudyScheduleService,
                                       StudyScheduleRepository studyScheduleRepository) {
        this.modelMapper = modelMapper;
        this.domainStudyScheduleService = domainStudyScheduleService;
        this.studyScheduleRepository = studyScheduleRepository;
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

        // testStatus가 'N'이면 numProblemsPerParticipant를 0으로 설정
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
}
