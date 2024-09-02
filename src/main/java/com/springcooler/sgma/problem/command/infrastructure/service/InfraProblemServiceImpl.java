package com.springcooler.sgma.problem.command.infrastructure.service;

import com.springcooler.sgma.choice.command.application.service.AppChoiceService;
import com.springcooler.sgma.choice.command.domain.aggregate.vo.ProblemVO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class InfraProblemServiceImpl implements InfraProblemService {

    private final AppChoiceService appChoiceService;

    @Autowired
    public InfraProblemServiceImpl(AppChoiceService appChoiceService) {
        this.appChoiceService = appChoiceService;
    }

    @Transactional
    @Override
    public int requestRegistChoices(long problemId, String[] choices) {
        return appChoiceService.registChoices(new ProblemVO(problemId, choices));
    }


    @Override
    public Timestamp requestScheduleStartTime(long problemId) {
        return null;
    }
}
