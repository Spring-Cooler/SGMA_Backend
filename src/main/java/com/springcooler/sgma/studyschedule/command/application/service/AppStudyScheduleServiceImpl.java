package com.springcooler.sgma.studyschedule.command.application.service;

import com.springcooler.sgma.studyschedule.command.application.dto.StudyScheduleDTO;
import com.springcooler.sgma.studyschedule.command.domain.aggregate.StudySchedule;
import com.springcooler.sgma.studyschedule.command.domain.repository.StudyScheduleRepository;
import com.springcooler.sgma.studyschedule.command.domain.service.DomainStudyScheduleService;
import com.springcooler.sgma.studyschedule.command.infrastructure.service.InfraStudyScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppStudyScheduleServiceImpl implements AppStudyScheduleService {
    private final ModelMapper modelMapper;
    private final DomainStudyScheduleService domainStudyScheduleService;
    private final InfraStudyScheduleService infraStudyScheduleService;
    private final StudyScheduleRepository studyScheduleRepository;

    public AppStudyScheduleServiceImpl(ModelMapper modelMapper,
                                       DomainStudyScheduleService domainStudyScheduleService,
                                       InfraStudyScheduleService infraStudyScheduleService,
                                       StudyScheduleRepository studyScheduleRepository) {
        this.modelMapper = modelMapper;
        this.domainStudyScheduleService = domainStudyScheduleService;
        this.infraStudyScheduleService = infraStudyScheduleService;
        this.studyScheduleRepository = studyScheduleRepository;
    }

    // 스터디 일정 생성
    @Transactional
    @Override
    public StudySchedule registStudySchedule(StudyScheduleDTO createStudySchedule) {
        createStudySchedule.setNumParticipants(0);
        createStudySchedule.setTestAverage(0.0);
        createStudySchedule.setTestStandardDeviation(0.0);

        StudySchedule studySchedule = modelMapper.map(createStudySchedule, StudySchedule.class);
        return studyScheduleRepository.save(studySchedule);
    }

    // 스터디 일정 수정
    @Transactional
    @Override
    public StudySchedule modifyStudySchedule(Long scheduleId, StudyScheduleDTO updateStudySchedule) {
        StudySchedule existingSchedule = studyScheduleRepository.findById(scheduleId).orElse(null);

        if (existingSchedule != null) {
            Long currentGroupId = existingSchedule.getGroupId();
            updateStudySchedule.setScheduleId(existingSchedule.getScheduleId());
            modelMapper.map(updateStudySchedule, existingSchedule);
            existingSchedule.setGroupId(currentGroupId);

            // testStatus가 'n'이면 numProblemsPerParticipant를 0으로 설정
            if ("N".equalsIgnoreCase(updateStudySchedule.getTestStatus())) {
                existingSchedule.setNumProblemsPerParticipant(0);
            }
            return studyScheduleRepository.save(existingSchedule);
        }
        return null;
    }

    // 스터디 일정 삭제
//    @Transactional
//    @Override
//    public void deleteStudySchedule(long scheduleId) {
//        StudySchedule existingSchedule = studyScheduleRepository.findById(scheduleId).orElse(null);
//        if (existingSchedule != null) {
//            existingSchedule.setDeleted(true);  // 논리 삭제 설정
//            studyScheduleRepository.save(existingSchedule);
//        }
//    }
}
