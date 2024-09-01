package com.springcooler.sgma.submittedanswer.command.infrastructure.service;

import com.springcooler.sgma.problem.command.application.service.AppProblemService;
import com.springcooler.sgma.submittedanswer.command.application.service.AppSubmittedAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InfraSubmittedAnswerServiceImpl implements InfraSubmittedAnswerService
{

    private final AppProblemService appProblemService;

    @Autowired
    public InfraSubmittedAnswerServiceImpl(AppProblemService appProblemService) {
        this.appProblemService = appProblemService;
    }


    @Override
    public int getAnswerByProblemId(long problemId) {
        return appProblemService.getAnswerByProblemId(problemId);
    }
}
