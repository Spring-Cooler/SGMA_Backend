package com.springcooler.sgma.studygroupnotice.query.controller;

import com.springcooler.sgma.studygroupnotice.query.common.ResponseMessage;
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

        Map<String, Object> responseMap = studyGroupNoticeService.findStudyGroupNoticeByNoticeId(noticeId)
                .stream()
                .collect(
                        Collectors.toMap(
                                studyGroupNotice -> String.valueOf(studyGroupNotice.getNoticeId()),
                                Function.identity()
                        )
                );

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/group-id/{groupId}")
    public ResponseEntity<ResponseMessage> findStudyGroupNoticesByGroupId(@PathVariable long groupId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        Map<String, Object> responseMap = studyGroupNoticeService.findStudyGroupNoticesByGroupId(groupId)
                .stream()
                .collect(
                        Collectors.toMap(
                                studyGroupNotice -> String.valueOf(studyGroupNotice.getNoticeId()),
                                Function.identity()
                        )
                );

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

}
