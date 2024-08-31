package com.springcooler.sgma.recruitmentboard.command.application.controller;

import com.springcooler.sgma.recruitmentboard.command.application.dto.RecruitmentBoardCommandDTO;
import com.springcooler.sgma.recruitmentboard.command.application.service.RecruitmentBoardCommandService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/recruitment-board")
@AllArgsConstructor
@RequiredArgsConstructor
public class RecruitmentBoardCommandController {

    @Autowired
    private RecruitmentBoardCommandService recruitmentBoardCommandService;

    @PostMapping
    public ResponseEntity<RecruitmentBoardCommandDTO> createApplicant(@RequestBody RecruitmentBoardCommandDTO studyGroupApplicantCommandDTO) {
        recruitmentBoardCommandService.createStudyGroupApplicant(studyGroupApplicantCommandDTO);
        return ResponseEntity.ok(studyGroupApplicantCommandDTO);
    }

    @PutMapping("/{recruitmentBoardId}")
    public ResponseEntity<RecruitmentBoardCommandDTO> updateApplicant(@PathVariable Long recruitmentBoardId, @RequestBody RecruitmentBoardCommandDTO studyGroupApplicantCommandDTO) {
        RecruitmentBoardCommandDTO updatedDto = recruitmentBoardCommandService.updateStudyGroupApplicant(recruitmentBoardId, studyGroupApplicantCommandDTO);
        return updatedDto != null ? ResponseEntity.ok(updatedDto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{recruitmentBoardId}")
    public ResponseEntity<Void> deleteApplicant(@PathVariable Long recruitmentBoardId) {
        boolean isDeleted = recruitmentBoardCommandService.deleteStudyGroupApplicant(recruitmentBoardId);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}