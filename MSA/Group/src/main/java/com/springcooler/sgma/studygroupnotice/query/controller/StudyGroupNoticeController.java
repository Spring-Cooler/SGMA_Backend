package com.springcooler.sgma.studygroupnotice.query.controller;

import com.springcooler.sgma.studygroupnotice.common.ResponseDTO;
import com.springcooler.sgma.studygroupnotice.query.dto.StudyGroupNoticeDTO;
import com.springcooler.sgma.studygroupnotice.query.service.StudyGroupNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("queryStudyGroupNoticeController")
@RequestMapping("/api/study-group/notices")
public class StudyGroupNoticeController {

    private final StudyGroupNoticeService studyGroupNoticeService;

    @Autowired
    public StudyGroupNoticeController(StudyGroupNoticeService studyGroupNoticeService) {
        this.studyGroupNoticeService = studyGroupNoticeService;
    }

    // 스터디그룹 공지사항 전체 조회(스터디그룹 아이디)
    @GetMapping("/group-id/{groupId}")
    public ResponseDTO<?> findStudyGroupNoticesByGroupId(@PathVariable("groupId") Long groupId,
                                                         @RequestParam("page") Integer pageNo) {
        List<StudyGroupNoticeDTO> notices = studyGroupNoticeService.findStudyGroupNoticesByGroupId(groupId, pageNo);
        return ResponseDTO.ok(notices);
    }

    // 스터디그룹 공지사항 단건 조회(공지사항 아이디)
    @GetMapping("/{noticeId}")
    public ResponseDTO<?> findStudyGroupNoticeByNoticeId(@PathVariable("noticeId") Long noticeId) {
        StudyGroupNoticeDTO notice = studyGroupNoticeService.findStudyGroupNoticeByNoticeId(noticeId);
        return ResponseDTO.ok(notice);
    }

    // 스터디그룹 공지사항 제목으로 조회
    @GetMapping("/title/{title}")
    public ResponseDTO<?> findStudyGroupNoticesByTitle(@PathVariable("title") String title,
                                                       @RequestParam("page") Integer pageNo) {
        List<StudyGroupNoticeDTO> notices = studyGroupNoticeService.findStudyGroupNoticesByTitle(title, pageNo);
        return ResponseDTO.ok(notices);
    }

    // 스터디그룹 공지사항 내용으로 조회
    @GetMapping("/content/{content}")
    public ResponseDTO<?> findStudyGroupNoticesByContent(@PathVariable("content") String content,
                                                         @RequestParam("page") Integer pageNo) {
        List<StudyGroupNoticeDTO> notices = studyGroupNoticeService.findStudyGroupNoticesByContent(content, pageNo);
        return ResponseDTO.ok(notices);
    }

}
