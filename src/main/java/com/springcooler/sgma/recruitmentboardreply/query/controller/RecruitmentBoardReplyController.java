package com.springcooler.sgma.recruitmentboardreply.query.controller;

import com.springcooler.sgma.recruitmentboardreply.query.dto.RecruitmentBoardReplyDTO;
import com.springcooler.sgma.recruitmentboardreply.query.service.RecruitmentBoardReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecruitmentBoardReplyController {
    RecruitmentBoardReplyService recruitmentBoardReplyService;

    @Autowired
    public RecruitmentBoardReplyController(RecruitmentBoardReplyService recruitmentBoardReplyService) {
        this.recruitmentBoardReplyService = recruitmentBoardReplyService;
    }

    @GetMapping("/getAllReply")
    public List<RecruitmentBoardReplyDTO> findAllRecruitmentBoardApplicantList(){
        List<RecruitmentBoardReplyDTO> recruitmentBoardReplyDTO = recruitmentBoardReplyService.getAllRecruitmentBoardReply();
        return recruitmentBoardReplyDTO;
    }

}
