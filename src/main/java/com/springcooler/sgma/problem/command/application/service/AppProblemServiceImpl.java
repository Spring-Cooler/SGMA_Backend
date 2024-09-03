package com.springcooler.sgma.problem.command.application.service;

import com.springcooler.sgma.problem.command.application.dto.ProblemAndChoiceDTO;
import com.springcooler.sgma.problem.command.application.dto.ProblemDTO;
import com.springcooler.sgma.problem.command.domain.aggregate.entity.Problem;
import com.springcooler.sgma.problem.command.domain.repository.ProblemRepository;
import com.springcooler.sgma.studyscheduleparticipant.command.infrastructure.service.InfraStudyScheduleParticipantService;
import com.springcooler.sgma.problem.command.infrastructure.service.InfraProblemService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class AppProblemServiceImpl implements AppProblemService{

    private final ModelMapper modelMapper;
    private final ProblemRepository problemRepository;
    private final InfraProblemService infraProblemService;
    @Autowired
    public AppProblemServiceImpl(ModelMapper modelMapper, ProblemRepository problemRepository, InfraProblemService infraProblemService) {
        this.modelMapper = modelMapper;
        this.problemRepository = problemRepository;
        this.infraProblemService = infraProblemService;
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
    public Map<String,Object> registProblemAndChoice(ProblemAndChoiceDTO newProblemAndChoice) {
            Problem problem = new Problem(null,
                    newProblemAndChoice.getContent(),
                    newProblemAndChoice.getAnswer(),
                    newProblemAndChoice.getParticipantId(),
                    newProblemAndChoice.getScheduleId());

            Problem registeredProblem = problemRepository.save(problem);
            int numInsertedChoices = infraProblemService.requestRegistChoices(registeredProblem.getProblemId(), newProblemAndChoice.getChoices());
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("registeredproblem", registeredProblem);
            resultMap.put("numInsertedChoices", numInsertedChoices);

        return resultMap;

    }
}
