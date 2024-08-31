package com.springcooler.sgma.problem.command.domain.repository;

import com.springcooler.sgma.problem.command.domain.aggregate.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
    Optional<Problem> findById(Long problemId);
}
