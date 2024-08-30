package com.springcooler.sgma.problem.command.application.service;

import com.springcooler.sgma.problem.command.application.dto.ProblemDTO;
import com.springcooler.sgma.problem.command.domain.aggregate.Problem;
import com.springcooler.sgma.problem.command.domain.repository.ProblemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppProblemServiceImpl implements AppProblemService{

    private final ModelMapper modelMapper;
    private final ProblemRepository problemRepository;
    @Autowired
    public AppProblemServiceImpl(ModelMapper modelMapper, ProblemRepository problemRepository) {
        this.modelMapper = modelMapper;
        this.problemRepository = problemRepository;
    }

    @Transactional
    @Override
    public Problem registProblem(ProblemDTO newProblem) {
        Problem problem = modelMapper.map(newProblem, Problem.class);
        problemRepository.save(problem);
        return problem;
    }

    @Override
    public Problem modifyProblem(ProblemDTO modifiedProblem) {
        Problem existingProblem = problemRepository.findById(modifiedProblem.getProblemId()).orElseThrow(()->new EntityNotFoundException("Problem not found"));

        modelMapper.map(modifiedProblem, existingProblem);

        return problemRepository.save(existingProblem);

    }
}
