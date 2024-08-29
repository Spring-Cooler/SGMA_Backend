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
    public List<StudyGroupApplicantDTO> getAllStudyGroupApplicantList() {
        if(studyGroupApplicantService.studyGroupRecruitment().size()!=0) {
            return studyGroupApplicantService.studyGroupRecruitment();
        }
        else{
            return (List<StudyGroupApplicantDTO>) ResponseEntity.status(HttpStatus.FORBIDDEN).body("모집 글이 없습니다");
        }
    }

    @GetMapping("getstudygroup/{recruitmentBoardId}")
    public StudyGroupApplicantDTO findStudyGroupApplicantByRecruitmentBoardId(@PathVariable Long recruitmentBoardId) {
        return studyGroupApplicantService.selectStudyGroupApplicantById(recruitmentBoardId);
    }
}
