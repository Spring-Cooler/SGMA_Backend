package com.springcooler.sgma.problem.command.application.service;

import com.springcooler.sgma.choice.command.domain.aggregate.vo.ProblemVO;
import com.springcooler.sgma.problem.command.application.dto.ProblemAndChoiceDTO;
import com.springcooler.sgma.problem.command.domain.aggregate.entity.Problem;
import com.springcooler.sgma.problem.command.domain.repository.ProblemRepository;
import com.springcooler.sgma.problem.command.infrastructure.service.InfraProblemService;
import com.springcooler.sgma.problem.common.exception.CommonException;
import com.springcooler.sgma.problem.common.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class AppProblemServiceImpl implements AppProblemService {

    private final ProblemRepository problemRepository;
    private final InfraProblemService infraProblemService;

    @Autowired
    public AppProblemServiceImpl(ProblemRepository problemRepository, InfraProblemService infraProblemService) {
        this.problemRepository = problemRepository;
        this.infraProblemService = infraProblemService;
    }


    @Transactional
    @Override
    public void deleteProblem(long problemId) {
        Problem deleteProblem = problemRepository.findById(problemId).orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_PROBLEM));
        infraProblemService.requestDecreaseNumSubmittedProblems(deleteProblem.getScheduleId(), deleteProblem.getParticipantId());
        problemRepository.delete(deleteProblem);
    }



}