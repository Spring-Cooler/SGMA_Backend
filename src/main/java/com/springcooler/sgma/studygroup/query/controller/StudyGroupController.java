package com.springcooler.sgma.studygroup.query.controller;

import com.springcooler.sgma.studygroup.query.common.ResponseMessage;
import com.springcooler.sgma.studygroup.query.service.StudyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class StudyGroupController {
    private final StudyGroupService studyGroupService;

    @Autowired
    public StudyGroupController(StudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }

    @GetMapping("/study-groups")
    public ResponseEntity<ResponseMessage> findAllStudyGroups() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        Map<String, Object> responseMap = studyGroupService.findAllStudyGroupsByActiveStatus("ACTIVE")
                .stream()
                .collect(
                        Collectors.toMap(
                            studyGroup -> String.valueOf(studyGroup.getGroupId()),
                            Function.identity()
                        )
                );

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }
}
