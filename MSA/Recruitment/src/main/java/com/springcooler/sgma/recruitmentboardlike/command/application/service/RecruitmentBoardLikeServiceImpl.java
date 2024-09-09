package com.springcooler.sgma.recruitmentboardlike.command.application.service;

import com.springcooler.sgma.recruitmentboardlike.command.domain.aggregate.RecruitmentBoardLike;
import com.springcooler.sgma.recruitmentboardlike.command.domain.repository.RecruitmentBoardLikeRepository;
import com.springcooler.sgma.recruitmentboardlike.query.dto.RecruitmentBoardLikeDTO;
import com.springcooler.sgma.recruitmentboardlike.query.service.RecruitmentBoardLikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class RecruitmentBoardLikeServiceImpl implements RecruitmentBoardLikeCommandService {
    private final RecruitmentBoardLikeService recruitmentBoardLikeService;
    private final RecruitmentBoardLikeRepository recruitmentBoardLikeRepository;

    @Override
    public RecruitmentBoardLike checkLike(Long recruitmentBoardId, Long userId) {
        List<RecruitmentBoardLikeDTO> recruitmentBoardLikes = recruitmentBoardLikeService.findAllRecruitmentBoardLike();

        for (RecruitmentBoardLikeDTO like : recruitmentBoardLikes) {
            if (like.getRecruitmentBoardId().equals(recruitmentBoardId) && like.getUserId().equals(userId)) {
                RecruitmentBoardLike recruitmentLike = recruitmentBoardLikeRepository.findByRecruitmentBoardIdAndUserId(recruitmentBoardId, userId);
                if (recruitmentLike != null) {
                    recruitmentBoardLikeRepository.delete(recruitmentLike);
                    System.out.println("좋아요가 취소되었습니다.");
                    return null;
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
}
