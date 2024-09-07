package com.springcooler.sgma.recruitmentboardlike.command.application.service;

import com.springcooler.sgma.recruitmentboardlike.command.domain.aggregate.RecruitmentBoardLike;
import com.springcooler.sgma.recruitmentboardlike.query.dto.RecruitmentBoardLikeDTO;
import com.springcooler.sgma.recruitmentboardlike.query.repository.RecruitmentBoardLikeMapper;
import com.springcooler.sgma.recruitmentboardlike.query.service.RecruitmentBoardLikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class RecruitmentBoardLikeServiceImpl implements RecruitmentBoardLikeCommandService {
    @Autowired
    private RecruitmentBoardLikeService recruitmentBoardLikeService;

    @Autowired
    public RecruitmentBoardLikeServiceImpl(RecruitmentBoardLikeService recruitmentBoardLikeService) {
        this.recruitmentBoardLikeService = recruitmentBoardLikeService;

    }

    @Override
    public void addLike(Long recruitmentBoardId, Long userId) {
        log.info("================================");
        log.error("error=======================");
        log.info("완료");

        RecruitmentBoardLike recruitmentLike = RecruitmentBoardLike.builder()
                .recruitmentBoardId(recruitmentBoardId)
                .userId(userId)
                .build();
    }
}
