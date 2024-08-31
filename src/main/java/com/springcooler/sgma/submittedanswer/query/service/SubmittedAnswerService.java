package com.springcooler.sgma.submittedanswer.query.service;

import com.springcooler.sgma.submittedanswer.query.dto.SubmittedAnswerDTO;

import java.util.List;

public interface SubmittedAnswerService {

    List<SubmittedAnswerDTO> findAllSubmittedAnswers();
}
