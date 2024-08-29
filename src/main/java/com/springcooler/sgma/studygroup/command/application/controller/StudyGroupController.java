package com.springcooler.sgma.studygroup.command.application.controller;

import com.springcooler.sgma.studygroup.command.application.dto.StudyGroupDTO;
import com.springcooler.sgma.studygroup.command.application.service.AppStudyGroupService;
import com.springcooler.sgma.studygroupmember.command.application.dto.StudyGroupMemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController("commandStudyGroupController")
@RequestMapping("/api/study-groups")
@Slf4j
public class StudyGroupController {

    private final AppStudyGroupService studyGroupService;

    @Autowired
    public StudyGroupController(AppStudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }

    @PostMapping("/")
    public ResponseEntity<?> registStudyGroup(@RequestBody StudyGroupDTO newStudyGroup) {
        return ResponseEntity
                .created(URI.create("/api/study-groups/"
                                + studyGroupService.registStudyGroup(newStudyGroup).getGroupId()))
                .build();
    }

    @PostMapping("/member")
    public ResponseEntity<?> registAcceptedMember(@RequestBody StudyGroupMemberDTO newMember) {
        return ResponseEntity.ok(studyGroupService.registAcceptedMember(newMember));
    }

    @PutMapping("/")
    public ResponseEntity<?> modifyStudyGroup(@RequestBody StudyGroupDTO modifyStudyGroup) {
        return ResponseEntity.ok(studyGroupService.modifyStudyGroup(modifyStudyGroup));
    }

    @PatchMapping("/group-name")
    public ResponseEntity<?> modifyStudyGroupName(@RequestBody StudyGroupDTO modifyStudyGroup) {
        return ResponseEntity.ok(studyGroupService.modifyStudyGroupName(modifyStudyGroup));
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<?> deleteStudyGroup(@PathVariable long groupId) {
        studyGroupService.deleteStudyGroup(groupId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/member")
    public ResponseEntity<?> deleteQuitMember(@RequestParam("member-id") long memberId,
                                            @RequestParam("group-id") long groupId) {
        studyGroupService.deleteQuitMember(memberId, groupId);
        return ResponseEntity.noContent().build();
    }
}
