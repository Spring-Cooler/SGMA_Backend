package com.springcooler.sgma.submittedanswer.command.infrastructure.service;



public interface InfraSubmittedAnswerService {
    int getAnswerByProblemId(long problemId);

    void requestUpdateParticipantScore(Long scheduleId, Long participantId, Double score);
}
