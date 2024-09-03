package com.springcooler.sgma.studyscheduleparticipant.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "STUDY_SCHEDULE_PARTICIPANT")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyScheduleParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private Long participantId;

    @Column(name = "schedule_id", nullable = false)
    private Long scheduleId;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "submission_status", nullable = false)
    private String submissionStatus;

    @Column(name = "num_submitted_problems", nullable = false)
    private Integer numSubmittedProblems;

    @Column(name = "test_score", nullable = false)
    private Double testScore;

    @Column(name = "test_percentage", nullable = false)
    private Double testPercentage;
}
