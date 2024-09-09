package com.springcooler.sgma.recruitmentboardlike.command.application.controller;

import com.springcooler.sgma.recruitmentboardlike.command.application.service.RecruitmentBoardLikeServiceImpl;
import com.springcooler.sgma.recruitmentboardlike.command.domain.aggregate.RecruitmentBoardLike;
import com.springcooler.sgma.recruitmentboardcomment.common.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/recruitment-board-like")
@RequiredArgsConstructor
public class RecruitmentBoardLikeController {

    private final RecruitmentBoardLikeServiceImpl recruitmentBoardLikeService;

    @PostMapping("/like/{recruitmentBoardId}/{userId}")
    @Operation(summary = "모집글에 좋아요 추가 또는 취소")
    public ResponseDTO<?> addLike(@PathVariable("recruitmentBoardId") Long recruitmentBoardId, @PathVariable("userId") Long userId) {
        RecruitmentBoardLike result = recruitmentBoardLikeService.addLike(recruitmentBoardId, userId);
        return ResponseDTO.ok(result);
    }

    @DeleteMapping("/like/{recruitmentBoardId}/{userId}")
    @Operation(summary = "모집글에 좋아요 추가 또는 취소")
    public ResponseDTO<?> deleteLike(@PathVariable("recruitmentBoardId") Long recruitmentBoardId, @PathVariable("userId") Long userId) {
        RecruitmentBoardLike result = recruitmentBoardLikeService.deleteLike(recruitmentBoardId, userId);
        return ResponseDTO.ok(result);

    }
}
