package com.springcooler.sgma.submittedanswer.command.application.service;


import com.springcooler.sgma.submittedanswer.command.application.dto.SubmittedAnswerDTO;
import com.springcooler.sgma.submittedanswer.command.domain.aggregate.SubmittedAnswer;
import com.springcooler.sgma.submittedanswer.command.domain.aggregate.SubmittedAnswerPK;
import com.springcooler.sgma.submittedanswer.command.domain.repository.SubmittedAnswerRepository;
import com.springcooler.sgma.submittedanswer.command.infrastructure.service.InfraSubmittedAnswerService;
import com.springcooler.sgma.submittedanswer.command.infrastructure.service.InfraSubmittedAnswerServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppSubmittedAnswerServiceImpl implements AppSubmittedAnswerService {

    private final ModelMapper modelMapper;
    private final SubmittedAnswerRepository submittedAnswerRepository;
    private final InfraSubmittedAnswerService infraSubmittedAnswerService;
    @Autowired
    public AppSubmittedAnswerServiceImpl(ModelMapper modelMapper, SubmittedAnswerRepository submittedAnswerRepository, InfraSubmittedAnswerService infraSubmittedAnswerService) {
        this.modelMapper = modelMapper;
        this.submittedAnswerRepository = submittedAnswerRepository;
        this.infraSubmittedAnswerService = infraSubmittedAnswerService;
    }

    @Override
    @Transactional
    public SubmittedAnswer registSubmittedAnswer(SubmittedAnswerDTO newSubmittedAnswerDTO) {

        SubmittedAnswerPK newSubmittedAnswerPK = new SubmittedAnswerPK(newSubmittedAnswerDTO.getProblemId(), newSubmittedAnswerDTO.getParticipantId());
        Integer rightAnswer = infraSubmittedAnswerService.getAnswerByProblemId(newSubmittedAnswerDTO.getProblemId());
        if (rightAnswer == newSubmittedAnswerDTO.getSubmittedAnswer()) {
                newSubmittedAnswerDTO.setAnswerStatus("RIGHT");
        }
        else {
            newSubmittedAnswerDTO.setAnswerStatus("WRONG");
        }

        SubmittedAnswer newSubmittedAnswer = new SubmittedAnswer(newSubmittedAnswerPK, newSubmittedAnswerDTO.getSubmittedAnswer(), newSubmittedAnswerDTO.getAnswerStatus());

        return submittedAnswerRepository.save(newSubmittedAnswer);
    }
}
