package com.springcooler.sgma.studygroup.command.application.controller;

import com.springcooler.sgma.studygroup.command.application.dto.StudyGroupDTO;
import com.springcooler.sgma.studygroup.command.application.service.AppStudyGroupService;
import com.springcooler.sgma.studygroup.command.domain.aggregate.StudyGroup;
import com.springcooler.sgma.studygroup.common.ResponseDTO;
import com.springcooler.sgma.studygroupmember.command.application.dto.StudyGroupMemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResponseDTO<?> registStudyGroup(@RequestBody StudyGroupDTO newStudyGroup) {
        StudyGroupDTO studyGroup = studyGroupService.registStudyGroup(newStudyGroup);
        return ResponseDTO.ok(studyGroup);
    }

    // 스터디 그룹장 신청 승인
    @PostMapping("/member")
    public ResponseDTO<?> registAcceptedMember(@RequestBody StudyGroupMemberDTO newMember) {
        StudyGroupDTO studyGroup = studyGroupService.registAcceptedMember(newMember);
        return ResponseDTO.ok(studyGroup);
    }

    // 스터디 그룹 정보 수정
    @PutMapping("/")
    public ResponseDTO<?> modifyStudyGroup(@RequestBody StudyGroupDTO modifyStudyGroup) {
        StudyGroupDTO studyGroup = studyGroupService.modifyStudyGroup(modifyStudyGroup);
        return ResponseDTO.ok(studyGroup);
    }

    // 스터디 그룹 이름 수정
    @PatchMapping("/group-name")
    public ResponseDTO<?> modifyStudyGroupName(@RequestBody StudyGroupDTO modifyStudyGroup) {
        StudyGroupDTO studyGroup = studyGroupService.modifyStudyGroupName(modifyStudyGroup);
        return ResponseDTO.ok(studyGroup);
    }

    // 스터디 그룹 카테고리 수정
    @PatchMapping("/category")
    public ResponseDTO<?> modifyStudyGroupCategory(@RequestBody StudyGroupDTO modifyStudyGroup) {
        StudyGroupDTO studyGroup = studyGroupService.modifyStudyGroupCategory(modifyStudyGroup);
        return ResponseDTO.ok(studyGroup);
    }

    // 스터디 그룹원 탈퇴
    @DeleteMapping("/member")
    public ResponseDTO<?> deleteQuitMember(@RequestParam("member-id") long memberId,
                                              @RequestParam("group-id") long groupId) {
        StudyGroupDTO studyGroup = studyGroupService.deleteQuitMember(memberId, groupId);
        return ResponseDTO.ok(studyGroup);
    }

    // 스터디 그룹 삭제
    @DeleteMapping("/{groupId}")
    public ResponseDTO<?> deleteStudyGroup(@PathVariable long groupId) {
        studyGroupService.deleteStudyGroup(groupId);
        return ResponseDTO.ok(null);
    }

}
