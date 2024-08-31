package com.springcooler.sgma.recruitmentboard.command.application.service;

import com.springcooler.sgma.recruitmentboard.command.application.dto.RecruitmentBoardCommandDTO;
import com.springcooler.sgma.recruitmentboard.command.domain.aggregate.BoardActiveStatus;
import com.springcooler.sgma.recruitmentboard.command.domain.aggregate.RecruitmentBoard;
import com.springcooler.sgma.recruitmentboard.command.domain.repository.RecruitmentBoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

@Service
public class RecruitmentBoardCommandService {

    @Autowired
    private RecruitmentBoardRepository recruitmentBoardRepository;

    @Autowired
    private ModelMapper modelMapper;

    // 현재 시스템 시간으로 Timestamp 생성

    public RecruitmentBoard createStudyGroupApplicant(RecruitmentBoardCommandDTO studyGroupApplicantCommandDTO) {
        // 한국 표준시(KST)로 현재 시간을 구합니다.
        ZonedDateTime nowKst = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        Timestamp currentTimestamp = Timestamp.from(nowKst.toInstant());
        System.out.println(currentTimestamp);
        RecruitmentBoard studyGroupApplicant = RecruitmentBoard.builder()
                .recruitmentBoardId(studyGroupApplicantCommandDTO.getRecruitmentBoardId())
                .title(studyGroupApplicantCommandDTO.getTitle())
                .createdAt(currentTimestamp)  // 한국 현재 시간을 설정합니다.
                .updatedAt(currentTimestamp)
                .recruitmentStartTime(studyGroupApplicantCommandDTO.getRecruitmentStartTime())
                .recruitmentEndTime(studyGroupApplicantCommandDTO.getRecruitmentEndTime())
                .activeStatus(BoardActiveStatus.valueOf("ACTIVE"))
                .likes(studyGroupApplicantCommandDTO.getLikes())//추후 수정
                .group_id(studyGroupApplicantCommandDTO.getGroupId())
                .study_group_category_id(studyGroupApplicantCommandDTO.getStudyGroupCategoryId())
                .build();
        System.out.println(currentTimestamp);

        return recruitmentBoardRepository.save(studyGroupApplicant);
    }

    public RecruitmentBoardCommandDTO updateStudyGroupApplicant(Long recruitmentBoardId, RecruitmentBoardCommandDTO dto) {
        Optional<RecruitmentBoard> optionalApplicant = recruitmentBoardRepository.findById(recruitmentBoardId);

        if (optionalApplicant.isPresent()) {
            RecruitmentBoard existingApplicant = optionalApplicant.get();
            existingApplicant.setTitle(dto.getTitle());
            existingApplicant.setRecruitmentStartTime(dto.getRecruitmentStartTime());
            existingApplicant.setRecruitmentEndTime(dto.getRecruitmentEndTime());

            // 현재 시간으로 updatedAt 필드를 갱신합니다.
            ZonedDateTime nowKst = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
            Timestamp currentTimestamp = Timestamp.from(nowKst.toInstant());
            existingApplicant.setUpdatedAt(currentTimestamp);

            // 업데이트된 엔티티를 저장합니다.
            RecruitmentBoard updatedApplicant = recruitmentBoardRepository.save(existingApplicant);

            // 업데이트된 엔티티를 DTO로 변환하여 반환합니다.
            return modelMapper.map(updatedApplicant, RecruitmentBoardCommandDTO.class);
        }

        // 해당 ID를 가진 신청자가 없으면 null을 반환합니다.
        return null;
    }

    public boolean deleteStudyGroupApplicant(Long recruitmentBoardId) {
        Optional<RecruitmentBoard> optionalApplicant = recruitmentBoardRepository.findById(recruitmentBoardId);

        if (optionalApplicant.isPresent()) {
            RecruitmentBoard applicantUpdate = optionalApplicant.get();
            applicantUpdate.setActiveStatus(BoardActiveStatus.INACTIVE);
            recruitmentBoardRepository.save(applicantUpdate);
            return true;
        } else {
            System.out.println("해당 ID를 가진 신청자를 찾을 수 없습니다.");
        }
        return false;
    }
}