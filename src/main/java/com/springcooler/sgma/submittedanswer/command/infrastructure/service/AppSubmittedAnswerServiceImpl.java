package com.springcooler.sgma.submittedanswer.command.infrastructure.service;


import com.springcooler.sgma.submittedanswer.command.application.dto.SubmittedAnswerDTO;
import com.springcooler.sgma.submittedanswer.command.domain.aggregate.SubmittedAnswer;
import com.springcooler.sgma.submittedanswer.command.domain.aggregate.SubmittedAnswerPK;
import com.springcooler.sgma.submittedanswer.command.domain.repository.SubmittedAnswerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppSubmittedAnswerServiceImpl implements AppSubmittedAnswerService {

    private final ModelMapper modelMapper;
    private final SubmittedAnswerRepository submittedAnswerRepository;

    @Autowired
    public AppSubmittedAnswerServiceImpl(ModelMapper modelMapper, SubmittedAnswerRepository submittedAnswerRepository) {
        this.modelMapper = modelMapper;
        this.submittedAnswerRepository = submittedAnswerRepository;
    }

    @Override
    public SubmittedAnswer registSubmittedAnswer(SubmittedAnswerDTO newSubmittedAnswerDTO) {

        SubmittedAnswerPK newSubmittedAnswerPK = new SubmittedAnswerPK(newSubmittedAnswerDTO.getProblemId(), newSubmittedAnswerDTO.getParticipantId());
        SubmittedAnswer newSubmittedAnswer = new SubmittedAnswer(newSubmittedAnswerPK, newSubmittedAnswerDTO.getSubmittedAnswer(), newSubmittedAnswerDTO.getAnswerStatus());

        return submittedAnswerRepository.save(newSubmittedAnswer);
    }
}
