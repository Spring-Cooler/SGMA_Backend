package com.springcooler.sgma.studygroupmember.command.application.controller;

import com.springcooler.sgma.studygroupmember.command.application.dto.StudyGroupMemberDTO;
import com.springcooler.sgma.studygroupmember.command.application.service.AppStudyGroupMemberService;
import com.springcooler.sgma.studygroupmember.common.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("commandStudyGroupMemberController")
@RequestMapping("/api/study-group/members")
@Slf4j
public class StudyGroupMemberController {

    private final AppStudyGroupMemberService studyGroupMemberService;

    @Autowired
    public StudyGroupMemberController(AppStudyGroupMemberService studyGroupMemberService) {
        this.studyGroupMemberService = studyGroupMemberService;
    }

    @PostMapping("/")
    public ResponseDTO<?> registStudyGroupMember(@RequestBody StudyGroupMemberDTO newMember) {
        StudyGroupMemberDTO member = studyGroupMemberService.registStudyGroupMember(newMember);
        return ResponseDTO.ok(member);
    }

    @PutMapping("/")
    public ResponseDTO<?> modifyStudyGroupMember(@RequestBody StudyGroupMemberDTO modifyMember) {
        StudyGroupMemberDTO member = studyGroupMemberService.modifyStudyGroupMember(modifyMember);
        return ResponseDTO.ok(member);
    }

    @DeleteMapping("/{memberId}")
    public ResponseDTO<?> deleteStudyGroupMember(@PathVariable Long memberId) {
        studyGroupMemberService.deleteStudyGroupMember(memberId);
        return ResponseDTO.ok(null);
    }

}
