package com.springcooler.sgma.studygroupnotice.command.domain.aggregate;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="STUDY_GROUP_NOTICE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyGroupNotice {

    @Id
    @Column(name="NOTICE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("notice_id")
    private Long noticeId;

    @Column(name="TITLE")
    @JsonProperty("title")
    private String title;

    @Column(name="CONTENT")
    @JsonProperty("content")
    private String content;

    @Column(name="CREATED_AT")
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @Column(name="UPDATED_AT")
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name="ACTIVE_STATUS")
    @JsonProperty("active_status")
    private StudyGroupNoticeStatus activeStatus;

    @Column(name="GROUP_ID")
    @JsonProperty("group_id")
    private Long groupId;

}
