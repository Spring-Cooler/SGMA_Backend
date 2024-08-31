package com.springcooler.sgma.recruitmentboard.command.domain.repository;

import com.springcooler.sgma.recruitmentboard.command.domain.aggregate.RecruitmentBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitmentBoardRepository extends JpaRepository<RecruitmentBoard,Long> {
    boolean existsByRecruitmentBoardId(Long recruitmentBoardId);
}
