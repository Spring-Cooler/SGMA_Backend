package com.springcooler.sgma.studygroupapplicant.command.domain.repository;

import com.springcooler.sgma.studygroupapplicant.command.domain.aggregate.StudyGroupApplicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyGroupApplicantRepository extends JpaRepository<StudyGroupApplicant,Long> {
    boolean existsByRecruitmentBoardId(Long recruitmentBoardId);
}
