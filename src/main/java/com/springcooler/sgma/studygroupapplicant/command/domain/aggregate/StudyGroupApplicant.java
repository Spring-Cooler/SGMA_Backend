package com.springcooler.sgma.studygroupapplicant.command.domain.aggregate;

import jakarta.persistence.*;

@Entity
public class StudyGroupApplicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @Column(name="application_status",nullable = false)
    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;

    @Column(name = "recruitment_board_id")
    private Long recruitmentBoardId;
}
