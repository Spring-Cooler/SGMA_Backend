package com.springcooler.sgma.recruitmentboardlike.command.application.service;

import com.springcooler.sgma.recruitmentboard.command.domain.aggregate.RecruitmentBoard;
import com.springcooler.sgma.recruitmentboard.command.domain.repository.RecruitmentBoardRepository;
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
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class RecruitmentBoardLikeServiceImpl implements RecruitmentBoardLikeCommandService {
    private final RecruitmentBoardLikeService recruitmentBoardLikeService;
    private final RecruitmentBoardLikeRepository recruitmentBoardLikeRepository;
    private final RecruitmentBoardRepository recruitmentBoardRepository;


    @Transactional
    @Override
    public RecruitmentBoardLike addLike(Long recruitmentBoardId, Long userId) {
        Optional<RecruitmentBoard> optionalRecruitmentBoard = recruitmentBoardRepository.findById(recruitmentBoardId);
        List<RecruitmentBoardLikeDTO> recruitmentBoardLikes = recruitmentBoardLikeService.findAllRecruitmentBoardLike();
        for (RecruitmentBoardLikeDTO like : recruitmentBoardLikes) {
            if (like.getRecruitmentBoardId().equals(recruitmentBoardId) && like.getUserId().equals(userId)) {
                RecruitmentBoardLike recruitmentLike = recruitmentBoardLikeRepository.findByRecruitmentBoardIdAndUserId(recruitmentBoardId, userId);
                if (recruitmentLike != null) {
                        throw new CommonException(ErrorCode.ALREADY_EXISTS);
                    }
                }
            }
        RecruitmentBoard recruitmentBoard = optionalRecruitmentBoard.get();

        RecruitmentBoard updatedRecruitmentBoard = recruitmentBoard.toBuilder()
                .likes(recruitmentBoard.getLikes()+1)
                .build();
        RecruitmentBoardLike recruitmentLike = RecruitmentBoardLike.builder()
                .recruitmentBoardId(recruitmentBoardId)
                .userId(userId)
                .build();
        recruitmentBoardRepository.save(updatedRecruitmentBoard);
        recruitmentBoardLikeRepository.save(recruitmentLike);
        return null;
    }

    @Transactional
    @Override
    public RecruitmentBoardLike deleteLike(Long recruitmentBoardId, Long userId) {
        Optional<RecruitmentBoard> optionalRecruitmentBoard = recruitmentBoardRepository.findById(recruitmentBoardId);
        List<RecruitmentBoardLikeDTO> recruitmentBoardLikes = recruitmentBoardLikeService.findAllRecruitmentBoardLike();
        if(recruitmentBoardLikes.size()==0) {
            throw new CommonException(ErrorCode.NOT_FOUND_LIKE);
        }
        else {
            for (RecruitmentBoardLikeDTO like : recruitmentBoardLikes) {
                if (like.getRecruitmentBoardId().equals(recruitmentBoardId) && like.getUserId().equals(userId)) {
                    RecruitmentBoard recruitmentBoard = optionalRecruitmentBoard.get();
                    RecruitmentBoard updatedRecruitmentBoard = recruitmentBoard.toBuilder()
                            .likes(recruitmentBoard.getLikes() - 1)
                            .build();
                    RecruitmentBoardLike recruitmentLike = recruitmentBoardLikeRepository.findByRecruitmentBoardIdAndUserId(recruitmentBoardId, userId);
                    recruitmentBoardLikeRepository.delete(recruitmentLike);
                    recruitmentBoardRepository.save(updatedRecruitmentBoard);
                    return null;
                } else {
                    throw new CommonException(ErrorCode.NOT_FOUND_LIKE);
                }
            }
        }
        return null;
    }
}

