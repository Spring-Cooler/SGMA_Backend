package com.springcooler.sgma.problem.command.infrastructure.service;

import com.springcooler.sgma.problem.command.domain.aggregate.vo.ScheduleParticipantVO;
import com.springcooler.sgma.problem.command.domain.aggregate.vo.ScheduleVO;

import java.sql.Timestamp;
import java.util.Map;

public interface InfraProblemService {
    int requestRegistChoices(long problemId, String[] choices);
    ScheduleVO requestScheduleInfo(long scheduleId);
    ScheduleParticipantVO requestScheduleParticipant(long scheduleId);
}
