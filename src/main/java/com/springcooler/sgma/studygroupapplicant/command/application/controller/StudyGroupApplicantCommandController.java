package com.springcooler.sgma.studygroupapplicant.command.application.controller;

import com.springcooler.sgma.studygroupapplicant.command.application.dto.StudyGroupApplicantCommandDTO;
import com.springcooler.sgma.studygroupapplicant.command.application.service.StudyGroupApplicantCommandService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/study-applicant")
@AllArgsConstructor
@RequiredArgsConstructor
public class StudyGroupApplicantCommandController {

    @Autowired
    private StudyGroupApplicantCommandService studyGroupApplicantService;


    @PostMapping("apply")
    public ResponseEntity<StudyGroupApplicantCommandDTO> applyApplicant(@RequestBody StudyGroupApplicantCommandDTO studyGroupApplicantCommandDTO){
        studyGroupApplicantService.applyStudyGroup(studyGroupApplicantCommandDTO);
        return ResponseEntity.ok(studyGroupApplicantCommandDTO);
    }

    @DeleteMapping("delete/{userId}")
    public ResponseEntity<Void> deleteApplicant(@PathVariable Long userId){
        studyGroupApplicantService.cancelStudyGroupApply(userId);
        return ResponseEntity.ok().build();
    }


}
