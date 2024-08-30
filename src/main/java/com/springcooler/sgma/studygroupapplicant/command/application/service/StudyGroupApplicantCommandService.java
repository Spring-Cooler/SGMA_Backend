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
import java.util.Optional;

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
        // 먼저 해당 ID를 가진 신청자가 있는지 확인합니다.
        Optional<StudyGroupApplicant> optionalApplicant = studyGroupApplicantRepository.findById(recruitmentBoardId);

        if (optionalApplicant.isPresent()) {
            StudyGroupApplicant existingApplicant = optionalApplicant.get();

            // DTO의 값을 기반으로 엔티티를 업데이트합니다.
            existingApplicant.setTitle(dto.getTitle());
            existingApplicant.setRecruitmentStartTime(dto.getRecruitmentStartTime());
            existingApplicant.setRecruitmentEndTime(dto.getRecruitmentEndTime());
            existingApplicant.setActiveStatus(BoardActiveStatus.valueOf(dto.getActiveStatus()));
            existingApplicant.setLikes(dto.getLikes()); // 이 부분은 필요에 따라 조정합니다.
            existingApplicant.setGroup_id(dto.getGroupId());
            existingApplicant.setStudy_group_category_id(dto.getStudyGroupCategoryId());

            // 현재 시간으로 updatedAt 필드를 갱신합니다.
            ZonedDateTime nowKst = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
            Timestamp currentTimestamp = Timestamp.from(nowKst.toInstant());
            existingApplicant.setUpdatedAt(currentTimestamp);

            // 업데이트된 엔티티를 저장합니다.
            StudyGroupApplicant updatedApplicant = studyGroupApplicantRepository.save(existingApplicant);

            // 업데이트된 엔티티를 DTO로 변환하여 반환합니다.
            return modelMapper.map(updatedApplicant, StudyGroupApplicantCommandDTO.class);
        }

        // 해당 ID를 가진 신청자가 없으면 null을 반환합니다.
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
            return false;
        }
    }
}
