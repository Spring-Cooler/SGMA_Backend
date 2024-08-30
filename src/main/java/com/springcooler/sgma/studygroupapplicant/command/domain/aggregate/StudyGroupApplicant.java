package com.springcooler.sgma.studygroupapplicant.command.domain.aggregate;


import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Entity
public class StudyGroupApplicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="recruitment_board_id")
    private Long recruitmentBoardId;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String title;

    @Column(name = "created_at",columnDefinition = "TIMESTAMP",nullable = false)
    private java.sql.Timestamp createdAt;

    @Column(name = "updated_at",columnDefinition = "TIMESTAMP",nullable = false)
    private java.sql.Timestamp updatedAt;
    @Column(name = "recruitment_start_time",columnDefinition = "TIMESTAMP",nullable = false)
    private java.sql.Timestamp recruitmentStartTime;
    @Column(name = "recruitment_end_time",columnDefinition = "TIMESTAMP",nullable = false)
    private java.sql.Timestamp recruitmentEndTime;

    @Column(name="active_status",nullable = false)
    @Enumerated(EnumType.STRING)
    private BoardActiveStatus activeStatus;

    @Column(nullable = false)
    private int likes;

    private long group_id;

    private int study_group_category_id;


}
