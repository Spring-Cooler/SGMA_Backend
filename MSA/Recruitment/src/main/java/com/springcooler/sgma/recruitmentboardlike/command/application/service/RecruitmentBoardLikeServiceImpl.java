package com.springcooler.sgma.recruitmentboardlike.command.application.service;

import com.springcooler.sgma.recruitmentboard.command.domain.aggregate.RecruitmentBoard;
import com.springcooler.sgma.recruitmentboard.command.domain.repository.RecruitmentBoardRepository;
import com.springcooler.sgma.recruitmentboardlike.command.domain.aggregate.RecruitmentBoardLike;
import com.springcooler.sgma.recruitmentboardlike.command.domain.aggregate.RecruitmentBoardLikeId;
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

//    @Transactional
//    @Override
//    public RecruitmentBoardLike deleteLike(Long recruitmentBoardId, Long userId) {
//        // 전체 좋아요 목록 조회
//        List<RecruitmentBoardLikeDTO> recruitmentBoardLikes = recruitmentBoardLikeService.findAllRecruitmentBoardLike();
//
//        // 해당 사용자의 좋아요가 있는지 확인
//        RecruitmentBoardLikeDTO foundLike = recruitmentBoardLikes.stream()
//                .filter(like -> like.getRecruitmentBoardId().equals(recruitmentBoardId) && like.getUserId().equals(userId))
//                .findFirst()
//                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_LIKE));
//
//        // RecruitmentBoard 조회
//        RecruitmentBoard recruitmentBoard = recruitmentBoardRepository.findById(recruitmentBoardId)
//                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_RECRUITMENT_BOARD));
//
//        // 좋아요 수 업데이트
//        RecruitmentBoard updatedRecruitmentBoard = recruitmentBoard.toBuilder()
//                .likes(recruitmentBoard.getLikes() - 1)
//                .build();
//
//        // RecruitmentBoardLike 삭제
//        RecruitmentBoardLike recruitmentLike = recruitmentBoardLikeRepository.findByRecruitmentBoardIdAndUserId(recruitmentBoardId, userId);
//        recruitmentBoardLikeRepository.delete(recruitmentLike);
//
//        // 게시글 업데이트 저장
//        recruitmentBoardRepository.save(updatedRecruitmentBoard);
//        return recruitmentLike;
//    }


    @Transactional
    @Override
    public void deleteLike(Long recruitmentBoardId, Long userId) {
        // 기존 엔티티 조회
        RecruitmentBoardLike existingLike =
                recruitmentBoardLikeRepository.findById(new RecruitmentBoardLikeId(recruitmentBoardId,userId))
                        .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_LIKE));

        recruitmentBoardLikeRepository.delete(existingLike);
    }

}

