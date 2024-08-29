package com.springcooler.sgma.problem.query.service;

import com.springcooler.sgma.problem.query.dto.ProblemDTO;
import com.springcooler.sgma.problem.query.repository.ProblemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QueryProblemServiceImpl implements QueryProblemService {
    private ProblemMapper problemMapper;

    @Autowired
    public QueryProblemServiceImpl(ProblemMapper problemMapper) {
        this.problemMapper = problemMapper;
    }

    public List<ProblemDTO> findAllProblems() {
        return problemMapper.findAllProblems();
    }

    public List<ProblemDTO> findProblemsByScheduleId(long scheduleId){
        return problemMapper.findProblemsByScheduleId(scheduleId);
    }

    public List<ProblemDTO> findProblemsByScheduleIdAndParticipantId(long participantId, long scheduleId){
        Map<String, Long> map = new HashMap<>();
        map.put("participantId", participantId);
        map.put("scheduleId", scheduleId);
        return problemMapper.findProblemsByScheduleIdAndParticipantId(map);
    }
}
