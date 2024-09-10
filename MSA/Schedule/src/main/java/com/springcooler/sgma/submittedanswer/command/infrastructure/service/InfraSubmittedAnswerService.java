package com.springcooler.sgma.submittedanswer.command.infrastructure.service;



public interface InfraSubmittedAnswerService {
    String getAnswerByProblemId(Long problemId);

    void requestUpdateParticipantScore(long scheduleId, long participantId, double score);
}
