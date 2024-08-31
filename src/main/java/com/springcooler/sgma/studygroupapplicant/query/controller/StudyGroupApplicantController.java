package com.springcooler.sgma.studygroupapplicant.query.controller;

import com.springcooler.sgma.studygroupapplicant.query.dto.StudyGroupApplicantDTO;
import com.springcooler.sgma.studygroupapplicant.query.service.StudyGroupApplicantService;



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
public class StudyGroupApplicantController {

    private final StudyGroupApplicantService studyGroupApplicantService;

    @Autowired
    public StudyGroupApplicantController(StudyGroupApplicantService studyGroupApplicantService) {
        this.studyGroupApplicantService = studyGroupApplicantService;
    }



    @GetMapping("getAll")
    public ResponseEntity<?> getAllStudyGroupApplicantList() {
        List<StudyGroupApplicantDTO> studyGroupApplicants = studyGroupApplicantService.studyGroupRecruitment();
        if(studyGroupApplicants.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("모집 글이 존재하지 않습니다");
        }
        else
            return ResponseEntity.ok(studyGroupApplicants);
    }


    @GetMapping("getstudygroup/{recruitmentBoardId}")
    public ResponseEntity<?> findStudyGroupApplicantByRecruitmentBoardId(@PathVariable Long recruitmentBoardId) {
        try {
            StudyGroupApplicantDTO applicantDTO = studyGroupApplicantService.selectStudyGroupApplicantById(recruitmentBoardId);
            return ResponseEntity.ok(applicantDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("해당 번호의 글이 존재하지 않습니다");
        }
    }
}
