package com.springcooler.sgma.studygroupmember.query.controller;

import com.springcooler.sgma.studygroupmember.query.common.ResponseMessage;
import com.springcooler.sgma.studygroupmember.query.dto.StudyGroupMemberDTO;
import com.springcooler.sgma.studygroupmember.query.service.StudyGroupMemberService;
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

@RestController("queryStudyGroupMemberController")
@RequestMapping("/api/study-group/members")
public class StudyGroupMemberController {

    StudyGroupMemberService studyGroupMemberService;

    @Autowired
    public StudyGroupMemberController(StudyGroupMemberService studyGroupMemberService) {
        this.studyGroupMemberService = studyGroupMemberService;
    }

    // 스터디 그룹원 단건 조회(그룹원 아이디)
    @GetMapping("/{memberId}")
    public ResponseEntity<ResponseMessage> findStudyGroupMemberByMemberId(@PathVariable long memberId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        return getResponseEntity(headers, studyGroupMemberService.findStudyGroupMemberByMemberId(memberId));
    }

    // 스터디 그룹원 그룹별 조회
    @GetMapping("/group-id/{groupId}")
    public ResponseEntity<ResponseMessage> findStudyGroupMembersByGroupId(@PathVariable long groupId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        return getResponseEntity(headers, studyGroupMemberService.findStudyGroupMembersByGroupId(groupId));
    }

    // 스터디 그룹원 회원별 조회
    @GetMapping("/user-id/{userId}")
    public ResponseEntity<ResponseMessage> findStudyGroupMembersByUserId(@PathVariable long userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        return getResponseEntity(headers, studyGroupMemberService.findStudyGroupMembersByUserId(userId));
    }

    private ResponseEntity<ResponseMessage> getResponseEntity(HttpHeaders headers, List<StudyGroupMemberDTO> members) {
        ResponseMessage responseMessage;

        // 조회되지 않은 경우
        if (members.isEmpty()) {
            responseMessage = new ResponseMessage(404, "조회 실패!", null);
            return new ResponseEntity<>(responseMessage, headers, HttpStatus.NOT_FOUND);
        }

        // 조회된 경우
        Map<String, Object> responseMap = members
                .stream()
                .collect(
                        Collectors.toMap(
                                studyGroupMember -> String.valueOf(studyGroupMember.getMemberId()),
                                Function.identity()
                        )
                );
        responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

}
