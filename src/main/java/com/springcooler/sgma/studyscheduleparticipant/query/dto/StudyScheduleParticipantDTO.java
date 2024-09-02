package com.springcooler.sgma.studyscheduleparticipant.query.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyScheduleParticipantDTO {
    private Long participantId;
    private Long scheduleId;
    private Long memberId;
    private String submissionStatus;
    private Integer numSubmittedProblems;
    private Double testScore;
    private Double testPercentage;
}
