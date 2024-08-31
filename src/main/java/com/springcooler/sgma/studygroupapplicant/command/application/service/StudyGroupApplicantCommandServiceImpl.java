package com.springcooler.sgma.studygroupapplicant.command.application.service;

import com.springcooler.sgma.recruitmentboard.command.domain.aggregate.RecruitmentBoard;
import com.springcooler.sgma.studygroupapplicant.command.application.dto.StudyGroupApplicantCommandDTO;
import com.springcooler.sgma.studygroupapplicant.command.domain.aggregate.ApplicationStatus;
import com.springcooler.sgma.studygroupapplicant.command.domain.aggregate.StudyGroupApplicant;
import com.springcooler.sgma.studygroupapplicant.command.domain.repository.StudyGroupApplicantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class StudyGroupApplicantCommandServiceImpl implements StudyGroupApplicantCommandService{

    private final StudyGroupApplicantRepository studyGroupApplicantRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public StudyGroupApplicantCommandServiceImpl(StudyGroupApplicantRepository studyGroupApplicantRepository, ModelMapper modelMapper) {
        this.studyGroupApplicantRepository = studyGroupApplicantRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudyGroupApplicant applyStudyGroup(StudyGroupApplicantCommandDTO studyGroupApplicantCommandDTO) {
        StudyGroupApplicant studyGroupApplicant = StudyGroupApplicant.builder()
                .userId(studyGroupApplicantCommandDTO.getUserId())
                .applicationStatus(ApplicationStatus.valueOf("WAIT"))
                .recruitmentBoardId(studyGroupApplicantCommandDTO.getRecruitmentBoardId())
                .build();
        return studyGroupApplicantRepository.save(studyGroupApplicant);
    }

    @Override
    public void cancelStudyGroupApply(long userId) {
        Optional<StudyGroupApplicant> studyGroupApplicant = studyGroupApplicantRepository.findById(userId);


    }
}
