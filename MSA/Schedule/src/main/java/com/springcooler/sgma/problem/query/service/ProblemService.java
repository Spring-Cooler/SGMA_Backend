package com.springcooler.sgma.problem.query.service;

import com.springcooler.sgma.problem.query.dto.ProblemDTO;

import java.util.List;

public interface ProblemService {

    // 문제 전체 조회
    public List<ProblemDTO> findAllProblems();

}
