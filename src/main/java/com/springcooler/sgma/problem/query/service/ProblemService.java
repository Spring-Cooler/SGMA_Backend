package com.springcooler.sgma.problem.query.service;

import com.springcooler.sgma.problem.query.dto.ProblemDTO;
import com.springcooler.sgma.problem.query.repository.ProblemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProblemService {
    private ProblemMapper problemMapper;

    @Autowired
    public ProblemService(ProblemMapper problemMapper) {
        this.problemMapper = problemMapper;
    }

    public List<ProblemDTO> findAllProblmes() {
        return problemMapper.findAllProblems();
    }

    public List<ProblemDTO> findProblemByScheduleId(long scheduleId){
        return problemMapper.findProblemByScheduleId(scheduleId);
    }

    public List<ProblemDTO> findProblemByUserIdAndScheduleId(long participantId, long scheduleId){
        Map<String, Long> map = new HashMap<>();
        map.put("participantId", participantId);
        map.put("scheduleId", scheduleId);
        return problemMapper.findProblemByParticipantIdAndScheduleId(map);
    }
}
