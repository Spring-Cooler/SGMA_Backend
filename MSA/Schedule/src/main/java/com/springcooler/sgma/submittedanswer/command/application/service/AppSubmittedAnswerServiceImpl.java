package com.springcooler.sgma.submittedanswer.command.application.service;


import com.springcooler.sgma.submittedanswer.command.application.dto.SubmittedAnswerDTO;
import com.springcooler.sgma.submittedanswer.command.domain.aggregate.SubmittedAnswer;
import com.springcooler.sgma.submittedanswer.command.domain.aggregate.SubmittedAnswerPK;
import com.springcooler.sgma.submittedanswer.command.domain.repository.SubmittedAnswerRepository;
import com.springcooler.sgma.submittedanswer.command.infrastructure.service.InfraSubmittedAnswerService;
import com.springcooler.sgma.submittedanswer.common.exception.CommonException;
import com.springcooler.sgma.submittedanswer.common.exception.ErrorCode;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AppSubmittedAnswerServiceImpl implements AppSubmittedAnswerService {

    private final SubmittedAnswerRepository submittedAnswerRepository;
    private final InfraSubmittedAnswerService infraSubmittedAnswerService;
    @Autowired
    public AppSubmittedAnswerServiceImpl(SubmittedAnswerRepository submittedAnswerRepository
            , InfraSubmittedAnswerService infraSubmittedAnswerService) {
        this.submittedAnswerRepository = submittedAnswerRepository;
        this.infraSubmittedAnswerService = infraSubmittedAnswerService;
    }

    @Override
    @Transactional
    public void registSubmittedAnswer(List<SubmittedAnswerDTO> submittedAnswerDTOs) {
        List<SubmittedAnswer> submittedAnswers = new ArrayList<>();

        submittedAnswerDTOs.forEach(
                submittedAnswer -> {
                    SubmittedAnswer newSubmittedAnswer = new SubmittedAnswer(submittedAnswer.getProblemId(),submittedAnswer.getParticipantId(), submittedAnswer.getSubmittedAnswer(), submittedAnswer.getAnswerStatus());
                    submittedAnswers.add(newSubmittedAnswer);
                }
        );
         submittedAnswerRepository.saveAll(submittedAnswers);

    }

    @Transactional
    @Override
    public SubmittedAnswer modifySubmittedAnswer(SubmittedAnswerDTO modifySubmittedAnswer) {
        SubmittedAnswerPK modifySubmittedAnswerPK = new SubmittedAnswerPK(modifySubmittedAnswer.getProblemId(), modifySubmittedAnswer.getParticipantId());
        SubmittedAnswer existingSubmittedAnswer = submittedAnswerRepository.findById(modifySubmittedAnswerPK).orElseThrow();

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
    public double gradeSubmittedAnswersByScheduleIdAndParticipantId(long scheduleId, long participantId) {
        List<SubmittedAnswer> submittedAnswers = submittedAnswerRepository.findByParticipantId(participantId);
        if (submittedAnswers == null || submittedAnswers.isEmpty()) {
            throw new CommonException(ErrorCode.NOT_FOUND_SUBMITTED_ANSWER);
        }
        int rightAnswer = 0;
        for (SubmittedAnswer submittedAnswer : submittedAnswers) {
            log.info("submittedAnswer before grade: {}", submittedAnswer);
            Long problemId = submittedAnswer.getProblemId();
            int answer = infraSubmittedAnswerService.getAnswerByProblemId(problemId);
            if (answer == submittedAnswer.getSubmittedAnswer()) {
                submittedAnswer.setAnswerStatus("RIGHT");
                rightAnswer++;
            }
            else {
                submittedAnswer.setAnswerStatus("WRONG");
            }
            log.info("submittedAnswer after grade: {}", submittedAnswer);
        }
        submittedAnswerRepository.saveAll(submittedAnswers);
        double score =  rightAnswer/(double)submittedAnswers.size();
        infraSubmittedAnswerService.requestUpdateParticipantScore(scheduleId, participantId, score);
        return score;
    }
}

