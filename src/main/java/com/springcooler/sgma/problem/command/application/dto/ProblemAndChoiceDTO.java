package com.springcooler.sgma.problem.command.application.dto;

import lombok.*;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProblemAndChoiceDTO {
    private long participantId;
    private long scheduleId;
    private String content;
    private int answer;
    private String[] choices;

}
