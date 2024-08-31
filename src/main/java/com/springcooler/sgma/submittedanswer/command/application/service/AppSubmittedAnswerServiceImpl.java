package com.springcooler.sgma.submittedanswer.command.application.service;


import com.springcooler.sgma.submittedanswer.command.application.dto.SubmittedAnswerDTO;
import com.springcooler.sgma.submittedanswer.command.domain.aggregate.SubmittedAnswer;
import com.springcooler.sgma.submittedanswer.command.domain.aggregate.SubmittedAnswerPK;
import com.springcooler.sgma.submittedanswer.command.domain.repository.SubmittedAnswerRepository;
import com.springcooler.sgma.submittedanswer.command.infrastructure.service.InfraSubmittedAnswerService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
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
//        Integer rightAnswer = infraSubmittedAnswerService.getAnswerByProblemId(newSubmittedAnswerDTO.getProblemId());
//        if (rightAnswer == newSubmittedAnswerDTO.getSubmittedAnswer()) {
//                newSubmittedAnswerDTO.setAnswerStatus("RIGHT");
//        }
//        else {
//            newSubmittedAnswerDTO.setAnswerStatus("WRONG");
//        }

        SubmittedAnswer newSubmittedAnswer = new SubmittedAnswer(newSubmittedAnswerPK, newSubmittedAnswerDTO.getSubmittedAnswer(), newSubmittedAnswerDTO.getAnswerStatus());

        return submittedAnswerRepository.save(newSubmittedAnswer);
    }

    @Transactional
    @Override
    public SubmittedAnswer modifySubmittedAnswer(SubmittedAnswerDTO modifySubmittedAnswer) {
        SubmittedAnswerPK modifySubmittedAnswerPK = new SubmittedAnswerPK(modifySubmittedAnswer.getProblemId(), modifySubmittedAnswer.getParticipantId());
        SubmittedAnswer existingSubmittedAnswer = submittedAnswerRepository.findById(modifySubmittedAnswerPK).orElseThrow(EntityNotFoundException::new);

        existingSubmittedAnswer.setSubmittedAnswer(modifySubmittedAnswer.getSubmittedAnswer());

        return submittedAnswerRepository.save(existingSubmittedAnswer);

    }

    @Transactional
    @Override
    public SubmittedAnswer findSubmittedAnswerByProblemIdAndParticipantId(long problemId, long participantId) {
        SubmittedAnswerPK submittedAnswerPK = new SubmittedAnswerPK(problemId, participantId);
        SubmittedAnswer foundSubmittedAnswer = submittedAnswerRepository.findById(submittedAnswerPK).orElseThrow(EntityNotFoundException::new);
        return foundSubmittedAnswer;
    }
    @Transactional
    @Override
    public void gradeSubmittedAnswer(SubmittedAnswerDTO submittedAnswerDTO) {

        SubmittedAnswerPK ungradedAnswerPK = new SubmittedAnswerPK(submittedAnswerDTO.getProblemId(), submittedAnswerDTO.getParticipantId());
        Integer rightAnswer = infraSubmittedAnswerService.getAnswerByProblemId(submittedAnswerDTO.getProblemId());
        if (rightAnswer == submittedAnswerDTO.getSubmittedAnswer()) {
            submittedAnswerDTO.setAnswerStatus("RIGHT");
        } else {
            submittedAnswerDTO.setAnswerStatus("WRONG");
        }

        SubmittedAnswer ungradedAnswer = submittedAnswerRepository.findById(ungradedAnswerPK).orElseThrow(EntityNotFoundException::new);
        ungradedAnswer.setAnswerStatus(submittedAnswerDTO.getAnswerStatus());
        submittedAnswerRepository.save(ungradedAnswer);



    }
}
