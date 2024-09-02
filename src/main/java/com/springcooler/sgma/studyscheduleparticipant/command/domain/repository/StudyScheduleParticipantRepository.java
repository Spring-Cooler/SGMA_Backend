package com.springcooler.sgma.studyscheduleparticipant.command.domain.repository;

import com.springcooler.sgma.studyscheduleparticipant.command.domain.aggregate.StudyScheduleParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyScheduleParticipantRepository extends JpaRepository<StudyScheduleParticipant, Long> {
}
