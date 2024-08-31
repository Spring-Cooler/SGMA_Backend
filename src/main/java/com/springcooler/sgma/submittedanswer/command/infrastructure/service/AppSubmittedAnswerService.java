package com.springcooler.sgma.submittedanswer.command.infrastructure.service;

import com.springcooler.sgma.submittedanswer.command.application.dto.SubmittedAnswerDTO;
import com.springcooler.sgma.submittedanswer.command.domain.aggregate.SubmittedAnswer;

public interface AppSubmittedAnswerService {
    SubmittedAnswer registSubmittedAnswer(SubmittedAnswerDTO newSubmittedAnswerDTO);
}
