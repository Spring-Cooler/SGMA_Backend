package com.springcooler.sgma.submittedanswer.command.domain.repository;

import com.springcooler.sgma.submittedanswer.command.domain.aggregate.SubmittedAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmittedAnswerRepository extends JpaRepository<SubmittedAnswer, Long> {
}
