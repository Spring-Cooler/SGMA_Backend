package com.springcooler.sgma.studygroupnotice.query.controller;

import com.springcooler.sgma.studygroupmember.query.dto.StudyGroupMemberDTO;
import com.springcooler.sgma.studygroupnotice.query.common.ResponseMessage;
import com.springcooler.sgma.studygroupnotice.query.dto.StudyGroupNoticeDTO;
import com.springcooler.sgma.studygroupnotice.query.service.StudyGroupNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController("queryStudyGroupNoticeController")
@RequestMapping("/api/study-group/notices")
public class StudyGroupNoticeController {

    private final StudyGroupNoticeService studyGroupNoticeService;

    @Autowired
    public StudyGroupNoticeController(StudyGroupNoticeService studyGroupNoticeService) {
        this.studyGroupNoticeService = studyGroupNoticeService;
    }

    @GetMapping("/{noticeId}")
    public ResponseEntity<ResponseMessage> findStudyGroupNoticeByNoticeId(@PathVariable long noticeId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        return getResponseEntity(headers, studyGroupNoticeService.findStudyGroupNoticeByNoticeId(noticeId));
    }

    @GetMapping("/group-id/{groupId}")
    public ResponseEntity<ResponseMessage> findStudyGroupNoticesByGroupId(@PathVariable long groupId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        return getResponseEntity(headers, studyGroupNoticeService.findStudyGroupNoticesByGroupId(groupId));
    }

    private ResponseEntity<ResponseMessage> getResponseEntity(HttpHeaders headers, List<StudyGroupNoticeDTO> notices) {
        ResponseMessage responseMessage;

        // 조회되지 않은 경우
        if (notices.isEmpty()) {
            responseMessage = new ResponseMessage(404, "조회 실패!", null);
            return new ResponseEntity<>(responseMessage, headers, HttpStatus.NOT_FOUND);
        }

        // 조회된 경우
        Map<String, Object> responseMap = notices
                .stream()
                .collect(
                        Collectors.toMap(
                                studyGroupNotice -> String.valueOf(studyGroupNotice.getNoticeId()),
                                Function.identity()
                        )
                );
        responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

}
