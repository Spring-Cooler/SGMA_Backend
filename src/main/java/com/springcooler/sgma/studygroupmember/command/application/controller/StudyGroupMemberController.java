package com.springcooler.sgma.studygroupmember.command.application.controller;

import com.springcooler.sgma.studygroupmember.command.application.dto.StudyGroupMemberDTO;
import com.springcooler.sgma.studygroupmember.command.application.service.AppStudyGroupMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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
    public ResponseEntity<?> registStudyGroupMember(@RequestBody StudyGroupMemberDTO newMember) {
        return ResponseEntity
                .created(URI.create("/api/study-group/members/"
                        + studyGroupMemberService.registStudyGroupMember(newMember).getMemberId()))
                .build();
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<?> modifyStudyGroupMember(@RequestBody StudyGroupMemberDTO modifyMember) {
        return ResponseEntity.ok(studyGroupMemberService.modifyStudyGroupMember(modifyMember));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<?> deleteStudyGroupMember(@PathVariable long memberId) {
        studyGroupMemberService.deleteStudyGroupMember(memberId);
        return ResponseEntity.noContent().build();
    }
}
