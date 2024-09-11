package com.springcooler.sgma.recruitmentboardlike.command.application.service;


import com.springcooler.sgma.recruitmentboardlike.command.domain.aggregate.RecruitmentBoardLike;
import org.springframework.stereotype.Service;

@Service
public interface RecruitmentBoardLikeCommandService {
    RecruitmentBoardLike addLike(Long recruitmentBoardId, Long userId);
    RecruitmentBoardLike deleteLike(Long recruitmentBoardId, Long userId);
}
