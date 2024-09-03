package com.springcooler.sgma.problem.command.infrastructure.service;

import com.springcooler.sgma.choice.command.domain.aggregate.vo.ProblemVO;


import java.util.List;


public interface InfraProblemService {
    ProblemVO requestRegistChoices(long problemId, List<String> choices);

<<<<<<< HEAD
    void requestIncreaseSubmittedProblems(long scheduleId, long participantId);
=======
    void requestIncreaseNumSubmittedProblems(long scheduleId, long participantId);

    void requestDecreaseNumSubmittedProblems(long scheduleId, long participantId);
>>>>>>> 0109b9839241e15fd909db42ee52f8c44270d970
}

