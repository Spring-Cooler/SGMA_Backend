package com.springcooler.sgma.problem.command.application.service;

import com.springcooler.sgma.problem.command.application.dto.ProblemAndChoiceDTO;


public interface AppProblemService {

    void deleteProblem(long problemId);


    ProblemAndChoiceDTO registProblemAndChoice(ProblemAndChoiceDTO newProblemAndChoice);
}
