package com.springcooler.sgma.problem.command.infrastructure.service;

import com.springcooler.sgma.choice.command.domain.aggregate.vo.ProblemVO;
import com.springcooler.sgma.problem.command.application.dto.ProblemAndChoiceDTO;
import com.springcooler.sgma.problem.command.domain.aggregate.vo.ScheduleParticipantVO;
import com.springcooler.sgma.problem.command.domain.aggregate.vo.ScheduleVO;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface InfraProblemService {
    ProblemVO requestRegistChoices(long problemId, List<String> choices);
    ScheduleVO requestScheduleInfo(long scheduleId);
    ScheduleParticipantVO requestScheduleParticipant(long scheduleId);
}
