package com.springcooler.sgma.recruitmentboard.query.controller;

import com.springcooler.sgma.recruitmentboard.query.dto.RecruitmentBoardDTO;
import com.springcooler.sgma.recruitmentboard.query.service.RecruitmentBoardService;


import com.springcooler.sgma.recruitmentboardcomment.common.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("queryRecruitmentBoardController")
@RequestMapping("/api/recruitment-board")
public class RecruitmentBoardController {

    private final RecruitmentBoardService recruitmentBoardService;

    @Autowired
    public RecruitmentBoardController(RecruitmentBoardService studyGroupApplicantService) {
        this.recruitmentBoardService = studyGroupApplicantService;
    }

    @GetMapping("")
    @Operation(summary = "모집글 전체 조회")
    public ResponseDTO<?> findAllRecruitmentBoards() {
        List<RecruitmentBoardDTO> recruitmentBoards = recruitmentBoardService.findAllRecruitmentBoards();
        return ResponseDTO.ok(recruitmentBoards);
    }


    @GetMapping("/{recruitmentBoardId}")
    @Operation(summary = "모집글 Id로 조회")
    public ResponseDTO<?> findRecruitmentBoardByBoardId(@PathVariable("recruitmentBoardId") Long recruitmentBoardId) {
        RecruitmentBoardDTO recruitmentBoard =
                recruitmentBoardService.findRecruitmentBoardByBoardId(recruitmentBoardId);
        return ResponseDTO.ok(recruitmentBoard);
    }

    @GetMapping("title/{recruitmentBoardTitle}")
    @Operation(summary = "모집글 제목으로 조회")
    public ResponseDTO<?> findRecruitmentBoardByBoardTitle(@PathVariable("recruitmentBoardTitle") String recruitmentBoardTitle) {
        List<RecruitmentBoardDTO> recruitmentBoard = recruitmentBoardService.findRecruitmentBoardsByTitle(recruitmentBoardTitle);
        return ResponseDTO.ok(recruitmentBoard);
    }

}

