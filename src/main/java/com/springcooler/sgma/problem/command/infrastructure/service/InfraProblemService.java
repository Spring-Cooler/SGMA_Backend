package com.springcooler.sgma.problem.command.infrastructure.service;

import java.sql.Timestamp;
import java.util.Map;

public interface InfraProblemService {
    int requestRegistChoices(long problemId, String[] choices);
    Timestamp requestScheduleStartTime(long problemId);
}
