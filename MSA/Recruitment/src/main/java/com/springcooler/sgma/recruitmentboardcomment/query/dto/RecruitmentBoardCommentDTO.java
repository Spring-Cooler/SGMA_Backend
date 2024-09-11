package com.springcooler.sgma.recruitmentboardcomment.query.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.sql.Timestamp;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RecruitmentBoardCommentDTO {

    private Long recruitmentBoardCommentId;

    private String content;

    private Timestamp createdAt;


    private Timestamp updatedAt;

    private long userId;

    private String activeStatus;

    private long recruitmentBoardId;

    private String anonymousStatus;

}
