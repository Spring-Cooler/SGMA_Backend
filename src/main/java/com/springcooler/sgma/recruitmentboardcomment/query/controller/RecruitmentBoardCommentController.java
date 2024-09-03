package com.springcooler.sgma.recruitmentboardcomment.query.controller;

import com.springcooler.sgma.recruitmentboardcomment.query.dto.RecruitmentBoardCommentDTO;
import com.springcooler.sgma.recruitmentboardcomment.query.service.RecruitmentBoardCommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecruitmentBoardCommentController {
    private RecruitmentBoardCommentService recruitmentBoardCommentService;

    @Autowired
    public RecruitmentBoardCommentController(RecruitmentBoardCommentService recruitmentBoardCommentService) {
        this.recruitmentBoardCommentService = recruitmentBoardCommentService;
    }

    @GetMapping("getAll/BoardCommand/{recruitmentBoardId}")
    public List<RecruitmentBoardCommentDTO> findBoardCommentByRecruitmentBoardId(@PathVariable Long recruitmentBoardId){
        List<RecruitmentBoardCommentDTO> recruitmentBoardCommentDTO = recruitmentBoardCommentService.studyGroupRecruitmentComment(recruitmentBoardId);
        return recruitmentBoardCommentDTO;
    }
}
