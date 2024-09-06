package com.springcooler.sgma.recruitmentboardreply.query.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;


@Data
public class RecruitmentBoardReplyDTO {

    @JsonProperty("recruitment_board_reply_id")
    private Long recruitmentBoardReplyId;

    @JsonProperty("content")
    private String content;

    @JsonProperty("created_at")
    private Timestamp createdAt;

    @JsonProperty("updated_at")
    private Timestamp updatedAt;

    @JsonProperty("anonymous_status")
    private String anonymousStatus;

    @JsonProperty("active_status")
    private String activeStatus;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("recruitment_board_comment_id")
    private Long recruitmentBoardCommentId;

}


