package com.springcooler.sgma.recruitmentboard.query.controller;

import com.springcooler.sgma.recruitmentboard.query.dto.RecruitmentBoardDTO;
import com.springcooler.sgma.recruitmentboard.query.service.RecruitmentBoardService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/study-group-applicant")
public class RecruitmentBoardController {

    private final RecruitmentBoardService recruitmentBoardService;

    @Autowired
    public RecruitmentBoardController(RecruitmentBoardService studyGroupApplicantService) {
        this.recruitmentBoardService = studyGroupApplicantService;
    }



    @GetMapping("getAll")
    public ResponseEntity<?> findAllRecruitmentBoardApplicantList() {
        List<RecruitmentBoardDTO> studyGroupApplicants = recruitmentBoardService.studyGroupRecruitment();
        if(studyGroupApplicants.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("모집 글이 존재하지 않습니다");
        }
        else
            return ResponseEntity.ok(studyGroupApplicants);
    }


    @GetMapping("getstudygroup/{recruitmentBoardId}")
    public ResponseEntity<?> findRecruitmentBoardByRecruitmentBoardId(@PathVariable Long recruitmentBoardId) {
        try {
            RecruitmentBoardDTO applicantDTO = recruitmentBoardService.selectStudyGroupApplicantById(recruitmentBoardId);
            return ResponseEntity.ok(applicantDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("해당 번호의 글이 존재하지 않습니다");
        }
    }
}
