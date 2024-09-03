package com.springcooler.sgma.choice.query.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ChoiceDTO {
    private long problemId;
    private long choiceNum;
    private String content;
}
