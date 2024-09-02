package com.springcooler.sgma.choice.query.dto;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

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
