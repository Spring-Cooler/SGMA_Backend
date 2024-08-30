package com.springcooler.sgma.studygroupnotice.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

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
    private long noticeId;

    @Column(name="TITLE")
    private String title;

    @Column(name="CONTENT")
    private String content;

    @Column(name="CREATED_AT")
    private Timestamp createdAt;

    @Column(name="UPDATED_AT")
    private Timestamp updatedAt;

    @Column(name="ACTIVE_STATUS")
    private String activeStatus;

    @Column(name="GROUP_ID")
    private long groupId;

}
