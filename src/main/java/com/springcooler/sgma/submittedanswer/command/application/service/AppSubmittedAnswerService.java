package com.springcooler.sgma.submittedanswer.command.application.service;

import com.springcooler.sgma.studyscheduleparticipant.command.domain.aggregate.StudyScheduleParticipant;
import com.springcooler.sgma.studyscheduleparticipant.query.dto.StudyScheduleParticipantDTO;
import com.springcooler.sgma.submittedanswer.command.application.dto.SubmittedAnswerDTO;
import com.springcooler.sgma.submittedanswer.command.domain.aggregate.SubmittedAnswer;

public interface AppSubmittedAnswerService {
    SubmittedAnswer registSubmittedAnswer(SubmittedAnswerDTO newSubmittedAnswerDTO);

    SubmittedAnswer modifySubmittedAnswer(SubmittedAnswerDTO modifySubmittedAnswer);

    SubmittedAnswer findSubmittedAnswerByProblemIdAndParticipantId(long problemId, long participantId);

<<<<<<< HEAD
    void gradeSubmittedAnswersByParticipantId(long participantId);
=======
    double gradeSubmittedAnswersByParticipantId(long scheduleId, long participantId);

//    void gradeSubmittedAnswersByParticipantId(long participantId);

>>>>>>> 0f6c58feede98b581129115d6b402051ada28868
}
