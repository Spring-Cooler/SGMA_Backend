package com.springcooler.sgma.user.query.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RecruitmentBoardCommentDTO {
    private Long commentId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String activeStatus;
    private String anonymousStatus;
    private Long userId;
    private List<RecruitmentBoardReplyDTO> replies;
}
