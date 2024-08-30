package com.springcooler.sgma.studygroupnotice.query.dto;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyGroupNoticeDTO {
    private long noticeId;
    private String title;
    private String content;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String activeStatus;
    private long groupId;
}
