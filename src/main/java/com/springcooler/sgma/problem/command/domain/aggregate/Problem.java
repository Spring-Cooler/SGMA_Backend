package com.springcooler.sgma.problem.command.domain.aggregate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="PROBLEM")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Problem {

    @Id
    @Column(name="problem_id")
    private long problemId;

    @Column(name="content")
    private String content;

    @Column(name="answer")
    private int answer;

    @Column(name="participant_id")
    private long participantId;

    @Column(name="schedule_id")
    private long scheduleId;

}
