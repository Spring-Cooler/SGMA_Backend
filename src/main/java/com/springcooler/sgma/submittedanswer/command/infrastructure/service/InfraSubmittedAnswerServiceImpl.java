package com.springcooler.sgma.submittedanswer.command.infrastructure.service;

import com.springcooler.sgma.problem.command.application.service.AppProblemService;
import com.springcooler.sgma.problem.query.service.ProblemService;
import com.springcooler.sgma.submittedanswer.command.application.service.AppSubmittedAnswerService;
import com.springcooler.sgma.submittedanswer.query.dto.SubmittedAnswerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InfraSubmittedAnswerServiceImpl implements InfraSubmittedAnswerService
{

    private final ProblemService problemService;
    @Autowired
    public InfraSubmittedAnswerServiceImpl(ProblemService problemService) {
        this.problemService = problemService;
    }


    @Override
    public int getAnswerByProblemId(long problemId) {
        return problemService.findProblemByProblemId(problemId).getAnswer();
    }


}
