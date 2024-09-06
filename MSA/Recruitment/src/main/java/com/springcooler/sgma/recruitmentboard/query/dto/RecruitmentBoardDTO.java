package com.springcooler.sgma.recruitmentboard.query.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class RecruitmentBoardDTO {

    @JsonProperty("recruitment_board_id")
    private Long recruitmentBoardId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonProperty("created_at")
    private Timestamp createdAt;

    @JsonProperty("updated_at")
    private Timestamp updatedAt;

    @JsonProperty("recruitment_start_time")
    private Timestamp recruitmentStartTime;

    @JsonProperty("recruitment_end_time")
    private Timestamp recruitmentEndTime;

    @JsonProperty("active_status")
    private String activeStatus;

    @JsonProperty("likes")
    private Integer likes;

    @JsonProperty("group_id")
    private Long groupId;

    @JsonProperty("category_id")
    private Integer studyGroupCategoryId;

}