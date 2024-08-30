package com.springcooler.sgma.studygroupnotice.command.application.controller;

import com.springcooler.sgma.studygroupnotice.command.application.dto.StudyGroupNoticeDTO;
import com.springcooler.sgma.studygroupnotice.command.application.service.AppStudyGroupNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController("commandStudyGroupNoticeController")
@RequestMapping("/api/study-group/notices")
public class StudyGroupNoticeController {

    private final AppStudyGroupNoticeService studyGroupNoticeService;

    @Autowired
    public StudyGroupNoticeController(AppStudyGroupNoticeService studyGroupNoticeService) {
        this.studyGroupNoticeService = studyGroupNoticeService;
    }

    // 스터디그룹 공지사항 생성
    @PostMapping("/")
    public ResponseEntity<?>  registStudyGroupNotice(@RequestBody StudyGroupNoticeDTO newNotice) {
        return ResponseEntity
                .created(URI.create("/api/study-group/notices/"
                        + studyGroupNoticeService.registStudyGroupNotice(newNotice).getNoticeId()))
                .build();
    }

}
