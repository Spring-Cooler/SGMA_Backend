package com.springcooler.sgma.recruitmentboard.command.application.service;

import com.springcooler.sgma.recruitmentboard.command.application.dto.RecruitmentBoardCommandDTO;
import com.springcooler.sgma.recruitmentboard.command.domain.aggregate.BoardActiveStatus;
import com.springcooler.sgma.recruitmentboard.command.domain.aggregate.RecruitmentBoard;
import com.springcooler.sgma.recruitmentboard.command.domain.repository.RecruitmentBoardRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

@Service
public class RecruitmentBoardCommandService {

    private static final Logger logger = LoggerFactory.getLogger(RecruitmentBoardCommandService.class);

    private final RecruitmentBoardRepository recruitmentBoardRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RecruitmentBoardCommandService(RecruitmentBoardRepository recruitmentBoardRepository, ModelMapper modelMapper) {
        this.recruitmentBoardRepository = recruitmentBoardRepository;
        this.modelMapper = modelMapper;
    }

    public RecruitmentBoard createStudyGroupApplicant(RecruitmentBoardCommandDTO recruitmentBoardCommandDTO) {
        Timestamp currentTimestamp = getCurrentTimestamp();

        Timestamp adjustedStartTime = subtractHours(recruitmentBoardCommandDTO.getRecruitmentStartTime(), 9);
        Timestamp adjustedEndTime = subtractHours(recruitmentBoardCommandDTO.getRecruitmentEndTime(), 9);

        RecruitmentBoard recruitmentBoard = RecruitmentBoard.builder()
                .recruitmentBoardId(recruitmentBoardCommandDTO.getRecruitmentBoardId())
                .title(recruitmentBoardCommandDTO.getTitle())
                .content(recruitmentBoardCommandDTO.getContent())
                .createdAt(currentTimestamp)
                .updatedAt(currentTimestamp)
                .recruitmentStartTime(adjustedStartTime)
                .recruitmentEndTime(adjustedEndTime)
                .activeStatus(BoardActiveStatus.valueOf("ACTIVE"))
                .likes(recruitmentBoardCommandDTO.getLikes())//추후 수정
                .group_id(recruitmentBoardCommandDTO.getGroupId())
                .study_group_category_id(recruitmentBoardCommandDTO.getStudyGroupCategoryId())
                .build();
        System.out.println(currentTimestamp);

        return recruitmentBoardRepository.save(recruitmentBoard);
    }

    public RecruitmentBoardCommandDTO updateStudyGroupApplicant(Long recruitmentBoardId, RecruitmentBoardCommandDTO recruitmentBoardCommandDTO) {
        Optional<RecruitmentBoard> optionalApplicant = recruitmentBoardRepository.findById(recruitmentBoardId);

        if (optionalApplicant.isPresent()) {
            RecruitmentBoard existingApplicant = optionalApplicant.get();
            existingApplicant.setTitle(recruitmentBoardCommandDTO.getTitle());
            existingApplicant.setContent(recruitmentBoardCommandDTO.getContent());
            existingApplicant.setRecruitmentStartTime(recruitmentBoardCommandDTO.getRecruitmentStartTime());
            existingApplicant.setRecruitmentEndTime(recruitmentBoardCommandDTO.getRecruitmentEndTime());

            ZonedDateTime nowKst = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
            Timestamp currentTimestamp = Timestamp.from(nowKst.toInstant());
            existingApplicant.setUpdatedAt(currentTimestamp);


            RecruitmentBoard updatedApplicant = recruitmentBoardRepository.save(existingApplicant);

            return modelMapper.map(updatedApplicant, RecruitmentBoardCommandDTO.class);
        }


        return null;
    }

    public boolean deleteStudyGroupApplicant(Long recruitmentBoardId) {
        Optional<RecruitmentBoard> optionalApplicant = recruitmentBoardRepository.findById(recruitmentBoardId);

        if (optionalApplicant.isPresent()) {
            RecruitmentBoard applicantUpdate = optionalApplicant.get();
            applicantUpdate.setActiveStatus(BoardActiveStatus.DELETED);
            recruitmentBoardRepository.save(applicantUpdate);
            return true;
        } else {
            System.out.println("해당 ID를 가진 신청자를 찾을 수 없습니다.");
        }
        return false;
    }
    private Timestamp getCurrentTimestamp() {
        ZonedDateTime nowKst = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        return Timestamp.from(nowKst.toInstant());
    }

    private Timestamp subtractHours(Timestamp timestamp, int hours) {
        Instant instant = timestamp.toInstant();
        Instant newInstant = instant.minus(java.time.Duration.ofHours(hours));
        return Timestamp.from(newInstant);
    }
}