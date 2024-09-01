package com.springcooler.sgma.submittedanswer.command.application.service;

import com.springcooler.sgma.submittedanswer.command.application.dto.SubmittedAnswerDTO;
import com.springcooler.sgma.submittedanswer.command.domain.aggregate.SubmittedAnswer;

public interface AppSubmittedAnswerService {
    SubmittedAnswer registSubmittedAnswer(SubmittedAnswerDTO newSubmittedAnswerDTO);

    SubmittedAnswer modifySubmittedAnswer(SubmittedAnswerDTO modifySubmittedAnswer);

    SubmittedAnswer findSubmittedAnswerByProblemIdAndParticipantId(long problemId, long participantId);

    SubmittedAnswer gradeSubmittedAnswer(SubmittedAnswerDTO submittedAnswerDTO);
}