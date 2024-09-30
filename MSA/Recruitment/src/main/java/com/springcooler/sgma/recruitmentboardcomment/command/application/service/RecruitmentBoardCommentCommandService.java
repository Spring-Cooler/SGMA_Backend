package com.springcooler.sgma.recruitmentboardcomment.command.application.service;

import com.springcooler.sgma.recruitmentboardcomment.command.application.dto.RecruitmentBoardCommentCommandDTO;
import com.springcooler.sgma.recruitmentboardcomment.command.domain.aggregate.RecruitmentBoardComment;
import org.springframework.transaction.annotation.Transactional;

public interface RecruitmentBoardCommentCommandService {


    RecruitmentBoardComment createRecruitmentBoardComment(Long recruitmentBoardId,RecruitmentBoardCommentCommandDTO recruitmentBoardCommentCommandDTO);


    RecruitmentBoardComment updateRecruitmentBoardComment(Long recruitmentBoardCommentId, RecruitmentBoardCommentCommandDTO recruitmentBoardCommentCommandDTO);


    RecruitmentBoardComment deleteRecruitmentBoardComment(Long recruitmentBoardCommentId);
}
