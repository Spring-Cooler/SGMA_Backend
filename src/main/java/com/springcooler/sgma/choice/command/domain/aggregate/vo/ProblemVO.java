package com.springcooler.sgma.choice.command.domain.aggregate.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProblemVO {
    private long problemId;
    private String[] choices;
}
