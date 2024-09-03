package com.springcooler.sgma.recruitmentboard.command.application.service;

import com.springcooler.sgma.recruitmentboard.command.application.dto.RecruitmentBoardCommandDTO;
import com.springcooler.sgma.recruitmentboard.command.domain.aggregate.RecruitmentBoard;
import org.springframework.transaction.annotation.Transactional;

public interface RecruitmentBoardCommandServiceImpl {
    RecruitmentBoard createStudyGroupApplicant(RecruitmentBoardCommandDTO recruitmentBoardCommandDTO);

    RecruitmentBoardCommandDTO updateStudyGroupApplicant(Long recruitmentBoardId,RecruitmentBoardCommandDTO recruitmentBoardCommandDTO);

    boolean deleteStudyGroupApplicant(Long recruitmentBoardId);
}
