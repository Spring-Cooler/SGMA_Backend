package com.springcooler.sgma.submittedanswer.command.domain.repository;

import com.springcooler.sgma.submittedanswer.command.domain.aggregate.SubmittedAnswer;
import com.springcooler.sgma.submittedanswer.command.domain.aggregate.SubmittedAnswerPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SubmittedAnswerRepository extends JpaRepository<SubmittedAnswer, SubmittedAnswerPK> {
List<SubmittedAnswer> findByParticipantId(Long participantId);
}
