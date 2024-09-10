package com.springcooler.sgma.problem.command.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProblemDTO {

    @JsonProperty("problem_id")
    private Long problemId;

    @JsonProperty("content")
    private String content;

    @JsonProperty("answer")
    private String answer;

    @JsonProperty("problem_type")
    private String problemType;

    @JsonProperty("participant_id")
    private long participantId;

    @JsonProperty("schedule_id")
    private long scheduleId;

}
