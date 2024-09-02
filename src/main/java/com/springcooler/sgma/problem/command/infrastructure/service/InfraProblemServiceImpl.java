package com.springcooler.sgma.problem.command.infrastructure.service;

import com.springcooler.sgma.choice.command.application.service.AppChoiceService;
import com.springcooler.sgma.choice.command.domain.aggregate.vo.ProblemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfraProblemServiceImpl implements InfraProblemService {

    private final AppChoiceService appChoiceService;

    @Autowired
    public InfraProblemServiceImpl(AppChoiceService appChoiceService) {
        this.appChoiceService = appChoiceService;
    }

    @Override
    public int requestRegistChoices(long problemId, String[] choices) {
        return appChoiceService.registChoices(new ProblemVO(problemId, choices));
    }
}
