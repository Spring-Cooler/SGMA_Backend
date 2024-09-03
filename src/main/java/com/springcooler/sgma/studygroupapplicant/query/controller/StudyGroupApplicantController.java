package com.springcooler.sgma.studygroupapplicant.query.controller;

import com.springcooler.sgma.recruitmentboard.query.dto.RecruitmentBoardDTO;
import com.springcooler.sgma.studygroupapplicant.query.dto.StudyGroupApplicantDTO;
import com.springcooler.sgma.studygroupapplicant.query.service.StudyGroupApplicantService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/applicant")
public class StudyGroupApplicantController {
    private final StudyGroupApplicantService studyGroupApplicantService;

    @Autowired

    public StudyGroupApplicantController(StudyGroupApplicantService studyGroupApplicantService) {
        this.studyGroupApplicantService = studyGroupApplicantService;
    }

    @GetMapping("recruitment/{recruitmentBoardId}")
    public ResponseEntity<?> findStudyGroupApplicantByRecruitmentBoardId(@PathVariable Long recruitmentBoardId) {
        try {
            List<StudyGroupApplicantDTO> studyGroupApplicantDTO =studyGroupApplicantService.selectStudyGroupApplicantByRecruitmentBoardId(recruitmentBoardId);
            return ResponseEntity.ok(studyGroupApplicantDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }


    @GetMapping("user/{userId}")
    public ResponseEntity<?> selectStudyGroupApplicantByUserId(@PathVariable Long userId) {
        try {
            List<StudyGroupApplicantDTO> studyGroupApplicantDTO =studyGroupApplicantService.selectStudyGroupApplicantByUserId(userId);
            return ResponseEntity.ok(studyGroupApplicantDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
