package com.springcooler.sgma.recruitmentboardcomment.command.application.controller;


import com.springcooler.sgma.recruitmentboardcomment.command.application.dto.RecruitmentBoardCommentCommandDTO;
import com.springcooler.sgma.recruitmentboardcomment.command.application.service.RecruitmentBoardCommentCommandService;
import com.springcooler.sgma.recruitmentboardcomment.command.domain.aggregate.RecruitmentBoardComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recruitment-board-comments")
public class RecruitmentBoardCommentCommandController {

    private final RecruitmentBoardCommentCommandService recruitmentBoardCommentCommandService;

    @Autowired
    public RecruitmentBoardCommentCommandController(RecruitmentBoardCommentCommandService recruitmentBoardCommentCommandService) {
        this.recruitmentBoardCommentCommandService = recruitmentBoardCommentCommandService;
    }

    @PostMapping("/{recruitmentBoardId}")
    public ResponseEntity<RecruitmentBoardComment> createComment(@PathVariable Long recruitmentBoardId, @RequestBody RecruitmentBoardCommentCommandDTO recruitmentBoardCommentCommandDTO) {
        RecruitmentBoardComment createdComment = recruitmentBoardCommentCommandService.createRecruitmentBoardComment(recruitmentBoardId, recruitmentBoardCommentCommandDTO);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecruitmentBoardComment> updateComment(@PathVariable Long id, @RequestBody RecruitmentBoardCommentCommandDTO recruitmentBoardCommentCommandDTO) {
        RecruitmentBoardComment updatedComment = recruitmentBoardCommentCommandService.updateRecruitmentBoardComment(id, recruitmentBoardCommentCommandDTO);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RecruitmentBoardComment> deleteComment(@PathVariable Long id, @RequestBody RecruitmentBoardCommentCommandDTO recruitmentBoardCommentCommandDTO) {
        recruitmentBoardCommentCommandService.deleteRecruitmentBoardComment(id, recruitmentBoardCommentCommandDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}