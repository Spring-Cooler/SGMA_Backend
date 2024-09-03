package com.springcooler.sgma.studygroupapplicant.command.application.controller;

import com.springcooler.sgma.studygroup.command.application.service.AppStudyGroupService;
import com.springcooler.sgma.studygroup.command.domain.aggregate.StudyGroup;
import com.springcooler.sgma.studygroupapplicant.command.application.dto.StudyGroupApplicantCommandDTO;
import com.springcooler.sgma.studygroupapplicant.command.application.service.StudyGroupApplicantCommandService;

import com.springcooler.sgma.studygroupmember.command.application.dto.StudyGroupMemberDTO;
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

    @Autowired
    private AppStudyGroupService appStudyGroupService;



    @PostMapping("apply")
    public ResponseEntity<StudyGroupApplicantCommandDTO> applyApplicant(@RequestBody StudyGroupApplicantCommandDTO studyGroupApplicantCommandDTO){
        studyGroupApplicantService.applyStudyGroup(studyGroupApplicantCommandDTO);
        return ResponseEntity.ok(studyGroupApplicantCommandDTO);
    }

    @DeleteMapping("delete/{userId}/{recruitmentBoardId}")
    public ResponseEntity<Void> deleteApplicant(@PathVariable Long userId, @PathVariable Long recruitmentBoardId){
        studyGroupApplicantService.cancelStudyGroupApply(userId, recruitmentBoardId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("approve/{userId}/{recruitmentBoardId}")
    public ResponseEntity<Void> approveApplicant(@PathVariable Long userId, @PathVariable Long recruitmentBoardId) {
        studyGroupApplicantService.approveStudyGroupApplicant(userId, recruitmentBoardId);
        return ResponseEntity.ok().build();
    }
}
