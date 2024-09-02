package com.springcooler.sgma.problem.command.application.service;

import com.springcooler.sgma.problem.command.application.dto.ProblemAndChoiceDTO;
import com.springcooler.sgma.problem.command.application.dto.ProblemDTO;
import com.springcooler.sgma.problem.command.domain.aggregate.entity.Problem;

import java.util.Map;

public interface AppProblemService {
    Problem registProblem(ProblemDTO newProblem);

    Problem modifyProblem(ProblemDTO modifiedProblem);

    void deleteProblem(long problemId);

    int getAnswerByProblemId(long problemId);

    Map<String,Object> registProblemAndChoice(ProblemAndChoiceDTO newProblemAndChoice);
}
