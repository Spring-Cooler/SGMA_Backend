package com.springcooler.sgma.studygroupapplicant.command.application.service;

import com.springcooler.sgma.studygroupapplicant.command.application.dto.StudyGroupApplicantCommandDTO;
import com.springcooler.sgma.studygroupapplicant.command.domain.aggregate.BoardActiveStatus;
import com.springcooler.sgma.studygroupapplicant.command.domain.aggregate.StudyGroupApplicant;
import com.springcooler.sgma.studygroupapplicant.command.domain.repository.StudyGroupApplicantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class StudyGroupApplicantCommandService {

    @Autowired
    private StudyGroupApplicantRepository studyGroupApplicantRepository;

    @Autowired
    private ModelMapper modelMapper;

    // 현재 시스템 시간으로 Timestamp 생성

    public StudyGroupApplicant createStudyGroupApplicant(StudyGroupApplicantCommandDTO studyGroupApplicantCommandDTO) {
        // 한국 표준시(KST)로 현재 시간을 구합니다.
        ZonedDateTime nowKst = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        Timestamp currentTimestamp = Timestamp.from(nowKst.toInstant());
        System.out.println(currentTimestamp);
        StudyGroupApplicant studyGroupApplicant = StudyGroupApplicant.builder()
                .recruitmentBoardId(studyGroupApplicantCommandDTO.getRecruitmentBoardId())
                .title(studyGroupApplicantCommandDTO.getTitle())
                .createdAt(currentTimestamp)  // 한국 현재 시간을 설정합니다.
                .updatedAt(currentTimestamp)
                .recruitmentStartTime(studyGroupApplicantCommandDTO.getRecruitmentStartTime())
                .recruitmentEndTime(studyGroupApplicantCommandDTO.getRecruitmentEndTime())
                .activeStatus(BoardActiveStatus.valueOf(studyGroupApplicantCommandDTO.getActiveStatus()))
                .likes(studyGroupApplicantCommandDTO.getLikes())//추후 수정
                .group_id(studyGroupApplicantCommandDTO.getGroupId())
                .study_group_category_id(studyGroupApplicantCommandDTO.getStudyGroupCategoryId())
                .build();
        System.out.println(currentTimestamp);

        return studyGroupApplicantRepository.save(studyGroupApplicant);
    }

    public StudyGroupApplicantCommandDTO updateStudyGroupApplicant(Long recruitmentBoardId, StudyGroupApplicantCommandDTO dto) {
        if (studyGroupApplicantRepository.existsById(recruitmentBoardId)) {
            StudyGroupApplicant applicantToUpdate = modelMapper.map(dto, StudyGroupApplicant.class);
            applicantToUpdate.setRecruitmentBoardId(recruitmentBoardId);
            StudyGroupApplicant updatedApplicant = studyGroupApplicantRepository.save(applicantToUpdate);
            return modelMapper.map(updatedApplicant, StudyGroupApplicantCommandDTO.class);
        }
        return null;
    }

    public boolean deleteStudyGroupApplicant(Long recruitmentBoardId) {
        if (studyGroupApplicantRepository.existsById(recruitmentBoardId)) {
            System.out.println("1.===================");
            studyGroupApplicantRepository.deleteById(recruitmentBoardId);
            return true;
        }
        else{
            System.out.println("2.=====================");
        }
        return false;
    }
}
