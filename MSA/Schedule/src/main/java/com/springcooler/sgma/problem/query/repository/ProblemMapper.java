package com.springcooler.sgma.problem.query.repository;

import com.springcooler.sgma.problem.query.dto.ProblemDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProblemMapper {
    List<ProblemDTO> findAllProblems();

}

