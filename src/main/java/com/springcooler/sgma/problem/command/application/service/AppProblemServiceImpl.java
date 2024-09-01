package com.springcooler.sgma.problem.command.application.service;

import com.springcooler.sgma.problem.command.application.dto.ProblemDTO;
import com.springcooler.sgma.problem.command.domain.aggregate.Problem;
import com.springcooler.sgma.problem.command.domain.repository.ProblemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Slf4j
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
//        log.info("newProblem: {}", newProblem);
        Problem problem = modelMapper.map(newProblem, Problem.class);
//        log.info("problemEntity: {}", problem);
        problem = problemRepository.save(problem);
//        log.info("problemSaved: {}", problem);
        return problem;
    }

    @Transactional
    @Override
    public Problem modifyProblem(ProblemDTO modifiedProblem) {
        Problem existingProblem = problemRepository.findById(modifiedProblem.getProblemId()).orElseThrow(()->new EntityNotFoundException("Problem not found"));

        modelMapper.map(modifiedProblem, existingProblem);

        return problemRepository.save(existingProblem);

    }
    @Transactional
    @Override
    public void deleteProblem(long problemId) {
        Problem deleteProblem  = problemRepository.findById(problemId).orElseThrow(()-> new EntityNotFoundException("Problem not found"));

        problemRepository.delete(deleteProblem);
    }

    @Transactional
    @Override
    public int getAnswerByProblemId(long problemId) {
        return problemRepository.findById(problemId).orElseThrow(()->new EntityNotFoundException("존재하지 않는 문제입니다.")).getAnswer();
    }
}
