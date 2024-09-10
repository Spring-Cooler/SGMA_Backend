package com.springcooler.sgma.studygroupboard.query.controller;

import com.springcooler.sgma.studygroupboard.common.ResponseDTO;
import com.springcooler.sgma.studygroupboard.query.dto.StudyGroupBoardDTO;
import com.springcooler.sgma.studygroupboard.query.service.StudyGroupBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("queryStudyGroupBoardController")
@RequestMapping("/api/study-group/boards")
public class StudyGroupBoardController {

    private final StudyGroupBoardService studyGroupBoardService;

    @Autowired
    public StudyGroupBoardController(StudyGroupBoardService studyGroupBoardService) {
        this.studyGroupBoardService = studyGroupBoardService;
    }

    // 게시글 그룹별 조회
    @GetMapping("/group-id/{groupId}")
    public ResponseDTO<?> findStudyGroupBoardsByGroupId(@PathVariable("groupId") Long groupId) {
        List<StudyGroupBoardDTO> boards = studyGroupBoardService.findStudyGroupBoardsByGroupId(groupId);
        return ResponseDTO.ok(boards);
    }

    // 게시글 그룹원별 조회
    @GetMapping("/member-id/{memberId}")
    public ResponseDTO<?> findStudyGroupBoardsByMemberId(@PathVariable("memberId") Long memberId) {
        List<StudyGroupBoardDTO> boards = studyGroupBoardService.findStudyGroupBoardsByMemberId(memberId);
        return ResponseDTO.ok(boards);
    }

    // 게시글 제목으로 조회
    @GetMapping("/title/{title}")
    public ResponseDTO<?> findStudyGroupBoardsByTitle(@PathVariable("title") String title) {
        List<StudyGroupBoardDTO> boards = studyGroupBoardService.findStudyGroupBoardsByTitle(title);
        return ResponseDTO.ok(boards);
    }

    // 게시글 내용으로 조회
    @GetMapping("/content/{content}")
    public ResponseDTO<?> findStudyGroupBoardsByContent(@PathVariable("content") String content) {
        List<StudyGroupBoardDTO> boards = studyGroupBoardService.findStudyGroupBoardsByContent(content);
        return ResponseDTO.ok(boards);
    }

    // 게시글 단건 조회
    @GetMapping("/{boardId}")
    public ResponseDTO<?> findStudyGroupBoardByBoardId(@PathVariable("boardId") Long boardId) {
        StudyGroupBoardDTO board = studyGroupBoardService.findStudyGroupBoardByBoardId(boardId);
        return ResponseDTO.ok(board);
    }

}
