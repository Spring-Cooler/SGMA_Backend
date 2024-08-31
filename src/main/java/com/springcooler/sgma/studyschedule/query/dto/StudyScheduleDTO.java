package com.springcooler.sgma.studyschedule.query.dto;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyScheduleDTO {
    private Long scheduleId;
    private String title;
    private String content;
    private Timestamp scheduleStartTime;
    private Timestamp scheduleEndTime;
    private Integer numParticipants;
    private Long groupId;
    private Integer numProblemsPerParticipant;
    private String testStatus;
    private Double testAverage;
    private Double testStandardDeviation;
}
