package com.springcooler.sgma.submittedanswer.command.domain.aggregate;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="SUBMITTED_ANSWER")
public class SubmittedAnswer {

    @EmbeddedId
    private SubmittedAnswerPK submittedAnswerPK;

    @Column(name="submitted_answer")
    private int submittedAnswer;

    @Column(name="answer_status")
    private String answerStatus;

}
