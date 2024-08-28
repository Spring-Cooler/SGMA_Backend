package com.springcooler.sgma.studygroup.command.application.controller;

import com.springcooler.sgma.studygroup.command.application.dto.StudyGroupDTO;
import com.springcooler.sgma.studygroup.command.application.service.StudyGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController("commandStudyGroupController")
@RequestMapping("/api/study-groups")
@Slf4j
public class StudyGroupController {
    private final StudyGroupService studyGroupService;

    @Autowired
    public StudyGroupController(StudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }

    @PostMapping("/")
    public ResponseEntity<?> registStudyGroup(@RequestBody StudyGroupDTO newStudyGroup) {
        log.info("registStudyGroup");
        return ResponseEntity
                .created(URI.create("/api/study-groups/"
                                + studyGroupService.registStudyGroup(newStudyGroup).getGroupId()))
                .build();
    }
}
