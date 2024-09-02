package com.springcooler.sgma.studygroupnotice.command.application.controller;

import com.springcooler.sgma.studygroupnotice.command.application.dto.StudyGroupNoticeDTO;
import com.springcooler.sgma.studygroupnotice.command.application.service.AppStudyGroupNoticeService;
import com.springcooler.sgma.studygroupnotice.command.domain.aggregate.StudyGroupNotice;
import com.springcooler.sgma.studygroupnotice.common.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResponseDTO<?> registStudyGroupNotice(@RequestBody StudyGroupNoticeDTO newNotice) {
        StudyGroupNotice notice = studyGroupNoticeService.registStudyGroupNotice(newNotice);
        return ResponseDTO.ok(notice);
    }

    // 스터디그룹 공지사항 정보 수정
    @PutMapping("/")
    public ResponseDTO<?> modifyStudyGroupNotice(@RequestBody StudyGroupNoticeDTO modifyNotice) {
        StudyGroupNotice notice = studyGroupNoticeService.modifyStudyGroupNotice(modifyNotice);
        return ResponseDTO.ok(notice);
    }

    // 스터디그룹 공지사항 삭제
    @DeleteMapping("/{noticeId}")
    public ResponseDTO<?> deleteStudyGroupNotice(@PathVariable Long noticeId) {
        studyGroupNoticeService.deleteStudyGroupNotice(noticeId);
        return ResponseDTO.ok(null);
    }

}
