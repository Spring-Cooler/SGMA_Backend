package com.springcooler.sgma.studygroupapplicant.query.dto;





import lombok.Data;

import java.sql.Timestamp;

@Data

public class StudyGroupApplicantDTO {
    private Long recruitmentBoardId;
    private String title;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp recruitmentStartTime;
    private Timestamp recruitmentEndTime;
    private String activeStatus;
    private int likes;
    private Long groupId;
    private int studyGroupCategoryId;
}