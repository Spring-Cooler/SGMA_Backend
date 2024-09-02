package com.springcooler.sgma.studyschedule.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="STUDY_SCHEDULE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudySchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="schedule_id")
    private Long scheduleId;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    @Column(name = "schedule_start_time",columnDefinition = "TIMESTAMP",nullable = false)
    private java.sql.Timestamp scheduleStartTime;

    @Column(name = "schedule_end_time",columnDefinition = "TIMESTAMP",nullable = false)
    private java.sql.Timestamp scheduleEndTime;

    @Column(name = "num_participants", nullable = false)
    private int numParticipants;

    @Column(name="test_status", columnDefinition = "TEXT", nullable = false)
    private String testStatus;

    @Column(name="test_average")
    private double testAverage;

    @Column(name="test_standard_deviation")
    private double testStandardDeviation;

    @Column(name="group_id")
    private long groupId;

    @Column(name="num_problems_per_participant")
    private int numProblemsPerParticipant;

    // 논리 삭제를 위한 필드 추가
//    @Column(name="is_deleted", nullable = false)
//    private boolean isDeleted = false;
}