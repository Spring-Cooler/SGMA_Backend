package com.springcooler.sgma.submittedanswer.command.domain.aggregate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
@ToString
@Getter
public class SubmittedAnswerPK implements Serializable {
    @Column(name = "problem_id")
    private long problemId;

    @Column(name="participant_id")
    private long participantId;
}
