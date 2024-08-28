package com.springcooler.sgma.problem.query.repository;

import com.springcooler.sgma.problem.query.dto.ProblemDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProblemMapper {
    List<ProblemDTO> findAllProblems();

    List<ProblemDTO> findProblemByScheduleId(long scheduleId);

    List<ProblemDTO> findProblemByParticipantIdAndScheduleId(Map<String, Long> map);
}

