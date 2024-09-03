package com.springcooler.sgma.studyscheduleparticipant.command.domain.repository;

import com.springcooler.sgma.studyscheduleparticipant.command.domain.aggregate.StudyScheduleParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudyScheduleParticipantRepository extends JpaRepository<StudyScheduleParticipant, Long> {
    Optional<StudyScheduleParticipant> findByScheduleIdAndMemberId(Long scheduleId, Long memberId);

    boolean existsByScheduleIdAndMemberId(Long scheduleId, Long memberId);
}
