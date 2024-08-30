package com.springcooler.sgma.studygroupapplicant.command.application.controller;

import com.springcooler.sgma.studygroupapplicant.command.application.dto.StudyGroupApplicantCommandDTO;
import com.springcooler.sgma.studygroupapplicant.command.application.service.StudyGroupApplicantCommandService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/study-group-applicants")
@AllArgsConstructor
@RequiredArgsConstructor
public class StudyGroupApplicantCommandController {

    @Autowired
    private StudyGroupApplicantCommandService studyGroupApplicantCommandService;

    @PostMapping
    public ResponseEntity<StudyGroupApplicantCommandDTO> createApplicant(@RequestBody StudyGroupApplicantCommandDTO studyGroupApplicantCommandDTO) {
        studyGroupApplicantCommandService.createStudyGroupApplicant(studyGroupApplicantCommandDTO);
        return ResponseEntity.ok(studyGroupApplicantCommandDTO);
    }

    @PutMapping("/{recruitmentBoardId}")
    public ResponseEntity<StudyGroupApplicantCommandDTO> updateApplicant(@PathVariable Long recruitmentBoardId, @RequestBody StudyGroupApplicantCommandDTO studyGroupApplicantCommandDTO) {
        StudyGroupApplicantCommandDTO updatedDto = studyGroupApplicantCommandService.updateStudyGroupApplicant(recruitmentBoardId, studyGroupApplicantCommandDTO);
        return updatedDto != null ? ResponseEntity.ok(updatedDto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{recruitmentBoardId}")
    public ResponseEntity<Void> deleteApplicant(@PathVariable Long recruitmentBoardId) {
        boolean isDeleted = studyGroupApplicantCommandService.deleteStudyGroupApplicant(recruitmentBoardId);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
