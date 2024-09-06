package com.springcooler.sgma.studygroupboard.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="STUDY_GROUP_BOARD")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyGroupBoard {

    @Id
    @Column(name="GROUP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

}
