package com.springcooler.sgma.submittedanswer.command.application.service;

import com.springcooler.sgma.submittedanswer.command.application.dto.SubmittedAnswerDTO;
import com.springcooler.sgma.submittedanswer.command.domain.aggregate.SubmittedAnswer;

import java.util.List;

public interface AppSubmittedAnswerService {
    void registSubmittedAnswer(List<SubmittedAnswerDTO> submittedAnswers);

    SubmittedAnswer modifySubmittedAnswer(SubmittedAnswerDTO modifySubmittedAnswer);


    double gradeSubmittedAnswersByScheduleIdAndParticipantId(Long scheduleId, Long participantId);


}
