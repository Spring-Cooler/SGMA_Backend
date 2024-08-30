package com.springcooler.sgma.studygroup.query.controller;

import com.springcooler.sgma.studygroup.query.common.ResponseMessage;
import com.springcooler.sgma.studygroup.query.service.StudyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController("queryStudyGroupController")
@RequestMapping("/api/study-groups")
public class StudyGroupController {

    private final StudyGroupService studyGroupService;

    @Autowired
    public StudyGroupController(StudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }

    // 스터디 그룹 전체 조회
    @GetMapping("/")
    public ResponseEntity<ResponseMessage> findAllStudyGroups() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        Map<String, Object> responseMap = studyGroupService.findAllStudyGroups()
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

    // 그룹장인 스터디 그룹 조회
    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<ResponseMessage> findStudyGroupsByOwnerId(@PathVariable long ownerId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        Map<String, Object> responseMap = studyGroupService.findStudyGroupsByOwnerId(ownerId)
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

    // 그룹원인 스터디 그룹 조회
    @GetMapping("/participant/{participantId}")
    public ResponseEntity<ResponseMessage> findStudyGroupsByParticipantId(@PathVariable long participantId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        Map<String, Object> responseMap = studyGroupService.findStudyGroupsByParticipantId(participantId)
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

    // 스터디 그룹 카테고리별 조회
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<ResponseMessage> findStudyGroupsByCategoryId(@PathVariable int categoryId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        Map<String, Object> responseMap = studyGroupService.findStudyGroupsByCategoryId(categoryId)
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

    // 스터디 그룹 단건 조회(그룹 아이디)
    @GetMapping("/{groupId}")
    public ResponseEntity<ResponseMessage> findStudyGroupByGroupId(@PathVariable long groupId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        Map<String, Object> responseMap = studyGroupService.findStudyGroupByGroupId(groupId)
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

    // 스터디 그룹 단건 조회(그룹 이름)
    @GetMapping("/group-name/{groupName}")
    public ResponseEntity<ResponseMessage> findStudyGroupByGroupName(@PathVariable String groupName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        Map<String, Object> responseMap = studyGroupService.findStudyGroupByGroupName(groupName)
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
