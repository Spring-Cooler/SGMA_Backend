package com.springcooler.sgma.problem.command.application.service;

import com.springcooler.sgma.problem.command.application.dto.ProblemDTO;
import com.springcooler.sgma.problem.command.domain.aggregate.Problem;

public interface AppProblemService {
    Problem registProblem(ProblemDTO newProblem);

    Problem modifyProblem(ProblemDTO modifiedProblem);
}
