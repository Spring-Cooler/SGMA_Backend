package com.springcooler.sgma.problem.query.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springcooler.sgma.choice.query.dto.ChoiceDTO;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProblemDTO {
    @JsonProperty("problem_id")
    private Long problemId;

    @JsonProperty("problem_id")
    private Long participantId;

    @JsonProperty("schedule_id")
    private Long scheduleId;

    @JsonProperty("content")
    private String content;

    @JsonProperty("problem_type")
    private String problemType;

    @JsonProperty("choices")
    private List<ChoiceDTO> choices;
}
