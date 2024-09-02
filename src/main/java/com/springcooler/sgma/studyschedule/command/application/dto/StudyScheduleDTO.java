package com.springcooler.sgma.studyschedule.command.application.dto;

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
    private String testStatus;
    private Double testAverage;
    private Double testStandardDeviation;
    private Long groupId;
    private Integer numProblemsPerParticipant;
}