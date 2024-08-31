package com.springcooler.sgma.studygroupapplicant.command.domain.repository;

import com.springcooler.sgma.studygroupapplicant.command.domain.aggregate.StudyGroupApplicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyGroupApplicantRepository extends JpaRepository<StudyGroupApplicant,Long> {
}
