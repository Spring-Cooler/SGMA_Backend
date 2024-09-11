package com.springcooler.sgma.recruitmentboardlike.command.domain.repository;

import com.springcooler.sgma.recruitmentboardlike.command.domain.aggregate.RecruitmentBoardLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitmentBoardLikeRepository extends JpaRepository<RecruitmentBoardLike,Long> {
    RecruitmentBoardLike findByRecruitmentBoardIdAndUserId(Long recruitmentBoardId, Long userId);
}
