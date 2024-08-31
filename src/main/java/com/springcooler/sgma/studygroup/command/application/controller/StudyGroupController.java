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

    // 스터디 그룹 생성
    @PostMapping("/")
    public ResponseEntity<?> registStudyGroup(@RequestBody StudyGroupDTO newStudyGroup) {
        return ResponseEntity
                .created(URI.create("/api/study-groups/"
                                + studyGroupService.registStudyGroup(newStudyGroup).getGroupId()))
                .build();
    }

    // 스터디 그룹장 신청 승인
    @PostMapping("/member")
    public ResponseEntity<?> registAcceptedMember(@RequestBody StudyGroupMemberDTO newMember) {
        return ResponseEntity.ok(studyGroupService.registAcceptedMember(newMember));
    }

    // 스터디 그룹 정보 수정
    @PutMapping("/")
    public ResponseEntity<?> modifyStudyGroup(@RequestBody StudyGroupDTO modifyStudyGroup) {
        return ResponseEntity.ok(studyGroupService.modifyStudyGroup(modifyStudyGroup));
    }

    // 스터디 그룹 이름 수정
    @PatchMapping("/group-name")
    public ResponseEntity<?> modifyStudyGroupName(@RequestBody StudyGroupDTO modifyStudyGroup) {
        return ResponseEntity.ok(studyGroupService.modifyStudyGroupName(modifyStudyGroup));
    }

    // 스터디 그룹 카테고리 수정
    @PatchMapping("/category")
    public ResponseEntity<?> modifyStudyGroupCategory(@RequestBody StudyGroupDTO modifyStudyGroup) {
        return ResponseEntity.ok(studyGroupService.modifyStudyGroupCategory(modifyStudyGroup));
    }

    // 스터디 그룹원 탈퇴
    @DeleteMapping("/member")
    public ResponseEntity<?> deleteQuitMember(@RequestParam("member-id") long memberId,
                                              @RequestParam("group-id") long groupId) {
        return ResponseEntity.ok(studyGroupService.deleteQuitMember(memberId, groupId));
    }

    // 스터디 그룹 삭제
    @DeleteMapping("/{groupId}")
    public ResponseEntity<?> deleteStudyGroup(@PathVariable long groupId) {
        studyGroupService.deleteStudyGroup(groupId);
        return ResponseEntity.noContent().build();
    }

}
