package com.springcooler.sgma.studygroupapplicant.query.controller;

import com.springcooler.sgma.studygroupapplicant.query.dto.StudyGroupApplicantDTO;
import com.springcooler.sgma.studygroupapplicant.query.service.StudyGroupApplicantService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/study-group-applicant")
@RequiredArgsConstructor
public class StudyGroupApplicantController {
    private final StudyGroupApplicantService studyGroupApplicantService;
    @GetMapping("getAll")
    public List<StudyGroupApplicantDTO> getAllStudyGroupApplicantList() {
        if(studyGroupApplicantService.studyGroupRecruitmentTest().size()!=0) {
            return studyGroupApplicantService.studyGroupRecruitmentTest();
        }
        else{
            return (List<StudyGroupApplicantDTO>) ResponseEntity.status(HttpStatus.FORBIDDEN).body("모집 글이 없습니다");
        }
    }
}
