package com.springcooler.sgma.submittedanswer.command.application.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SubmittedAnswerDTO {
    private long problemId;
    private long participantId;
    private int submittedAnswer;
    private String answerStatus;

}
