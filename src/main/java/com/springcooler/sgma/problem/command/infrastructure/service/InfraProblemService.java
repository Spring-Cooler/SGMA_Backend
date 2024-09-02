package com.springcooler.sgma.problem.command.infrastructure.service;

import java.util.Map;

public interface InfraProblemService {
    int requestRegistChoices(long problemId, String[] choices);
}
