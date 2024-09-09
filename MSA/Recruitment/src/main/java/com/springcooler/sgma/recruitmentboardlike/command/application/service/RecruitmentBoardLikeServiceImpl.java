package com.springcooler.sgma.recruitmentboardlike.command.application.service;

import com.springcooler.sgma.recruitmentboardlike.command.domain.aggregate.RecruitmentBoardLike;
import com.springcooler.sgma.recruitmentboardlike.command.domain.repository.RecruitmentBoardLikeRepository;
import com.springcooler.sgma.recruitmentboardlike.common.exception.CommonException;
import com.springcooler.sgma.recruitmentboardlike.common.exception.ErrorCode;
import com.springcooler.sgma.recruitmentboardlike.query.dto.RecruitmentBoardLikeDTO;
import com.springcooler.sgma.recruitmentboardlike.query.service.RecruitmentBoardLikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class RecruitmentBoardLikeServiceImpl implements RecruitmentBoardLikeCommandService {
    private final RecruitmentBoardLikeService recruitmentBoardLikeService;
    private final RecruitmentBoardLikeRepository recruitmentBoardLikeRepository;


    @Transactional
    @Override
    public RecruitmentBoardLike addLike(Long recruitmentBoardId, Long userId) {
        List<RecruitmentBoardLikeDTO> recruitmentBoardLikes = recruitmentBoardLikeService.findAllRecruitmentBoardLike();
        for (RecruitmentBoardLikeDTO like : recruitmentBoardLikes) {
            if (like.getRecruitmentBoardId().equals(recruitmentBoardId) && like.getUserId().equals(userId)) {
                RecruitmentBoardLike recruitmentLike = recruitmentBoardLikeRepository.findByRecruitmentBoardIdAndUserId(recruitmentBoardId, userId);
                if (recruitmentLike != null) {
                        throw new CommonException(ErrorCode.ALREADY_EXISTS);
                    }
                }
            }
            RecruitmentBoardLike recruitmentLike = RecruitmentBoardLike.builder()
                    .recruitmentBoardId(recruitmentBoardId)
                    .userId(userId)
                    .build();
            System.out.println("좋아요 추가 성공!");
        return recruitmentBoardLikeRepository.save(recruitmentLike);
    }

    @Transactional
    @Override
    public RecruitmentBoardLike deleteLike(Long recruitmentBoardId, Long userId) {
        List<RecruitmentBoardLikeDTO> recruitmentBoardLikes = recruitmentBoardLikeService.findAllRecruitmentBoardLike();

        for (RecruitmentBoardLikeDTO like : recruitmentBoardLikes) {
            if (like.getRecruitmentBoardId().equals(recruitmentBoardId) && like.getUserId().equals(userId)) {
                RecruitmentBoardLike recruitmentLike = recruitmentBoardLikeRepository.findByRecruitmentBoardIdAndUserId(recruitmentBoardId, userId);
                recruitmentBoardLikeRepository.delete(recruitmentLike);
                System.out.println("좋아요가 취소되었습니다.");
                return null;
            }
            else{
                throw new CommonException(ErrorCode.NOT_FOUND_LIKE);
            }
        }
        return null;
    }
}

