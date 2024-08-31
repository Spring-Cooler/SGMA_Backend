package com.springcooler.sgma.studygroupapplicant.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudyGroupApplicantCommandDTO {
    private Long recruitmentBoardId;
    private String title;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp recruitmentStartTime;
    private Timestamp recruitmentEndTime;
    private String activeStatus;
    private int likes;
    private long groupId;
    private int studyGroupCategoryId;
}