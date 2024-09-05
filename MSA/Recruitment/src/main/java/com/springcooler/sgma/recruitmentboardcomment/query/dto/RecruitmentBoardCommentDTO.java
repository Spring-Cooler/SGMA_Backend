package com.springcooler.sgma.recruitmentboardcomment.query.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class RecruitmentBoardCommentDTO {

    @JsonProperty("recruitment_board_comment_id")
    private Long recruitmentBoardCommentId;

    @JsonProperty("content")
    private String content;

    @JsonProperty("created_at")
    private Timestamp createdAt;

    @JsonProperty("updated_at")
    private Timestamp updatedAt;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("active_status")
    private String activeStatus;

    @JsonProperty("recruitment_board_id")
    private long recruitmentBoardId;

    @JsonProperty("anonymous_status")
    private String anonymousStatus;

}
