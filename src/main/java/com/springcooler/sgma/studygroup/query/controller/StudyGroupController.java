package com.springcooler.sgma.studygroup.query.controller;

import com.springcooler.sgma.studygroup.query.common.ResponseMessage;
import com.springcooler.sgma.studygroup.query.dto.StudyGroupDTO;
import com.springcooler.sgma.studygroup.query.service.StudyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;
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

        return getResponseEntity(headers, studyGroupService.findAllStudyGroups());
    }

    // 그룹장인 스터디 그룹 조회
    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<ResponseMessage> findStudyGroupsByOwnerId(@PathVariable long ownerId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        return getResponseEntity(headers, studyGroupService.findStudyGroupsByOwnerId(ownerId));
    }

    // 그룹원인 스터디 그룹 조회
    @GetMapping("/participant/{participantId}")
    public ResponseEntity<ResponseMessage> findStudyGroupsByParticipantId(@PathVariable long participantId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        return getResponseEntity(headers, studyGroupService.findStudyGroupsByParticipantId(participantId));
    }

    // 스터디 그룹 카테고리별 조회
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<ResponseMessage> findStudyGroupsByCategoryId(@PathVariable int categoryId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        return getResponseEntity(headers, studyGroupService.findStudyGroupsByCategoryId(categoryId));
    }

    // 스터디 그룹 단건 조회(그룹 아이디)
    @GetMapping("/{groupId}")
    public ResponseEntity<ResponseMessage> findStudyGroupByGroupId(@PathVariable long groupId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        return getResponseEntity(headers, studyGroupService.findStudyGroupByGroupId(groupId));
    }

    // 스터디 그룹 단건 조회(그룹 이름)
    @GetMapping("/group-name/{groupName}")
    public ResponseEntity<ResponseMessage> findStudyGroupByGroupName(@PathVariable String groupName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        return getResponseEntity(headers, studyGroupService.findStudyGroupByGroupName(groupName));
    }

    private ResponseEntity<ResponseMessage> getResponseEntity(HttpHeaders headers, List<StudyGroupDTO> studyGroups) {
        ResponseMessage responseMessage;

        // 조회되지 않은 경우
        if (studyGroups.isEmpty()) {
            responseMessage = new ResponseMessage(404, "조회 실패!", null);
            return new ResponseEntity<>(responseMessage, headers, HttpStatus.NOT_FOUND);
        }

        // 조회된 경우
        Map<String, Object> responseMap = studyGroups
                .stream()
                .collect(
                        Collectors.toMap(
                                studyGroup -> String.valueOf(studyGroup.getGroupId()),
                                Function.identity()
                        )
                );
        responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

}
