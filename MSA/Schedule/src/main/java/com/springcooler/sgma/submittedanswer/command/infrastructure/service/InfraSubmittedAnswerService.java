package com.springcooler.sgma.submittedanswer.command.infrastructure.service;


import com.springcooler.sgma.problem.query.dto.ProblemVO;

public interface InfraSubmittedAnswerService {
    int getAnswerByProblemId(long problemId);

    void requestUpdateParticipantScore(Long scheduleId, Long participantId, Double score);
}
