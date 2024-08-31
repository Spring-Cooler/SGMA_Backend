package com.springcooler.sgma.user.query.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecruitmentBoardReplyDTO {
    private Long replyId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String activeStatus;
    private String anonymousStatus;
    private Long userId;
    private Long commentId;
}
