package com.springcooler.sgma.problem.command.application.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProblemAndChoiceDTO {
    private Long problemId;
    private long participantId;
    private long scheduleId;
    private String content;
    private int answer;
    private List<String> choices;

}
