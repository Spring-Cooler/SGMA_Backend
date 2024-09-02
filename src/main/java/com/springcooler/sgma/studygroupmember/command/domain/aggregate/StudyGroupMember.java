package com.springcooler.sgma.studygroupmember.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name="STUDY_GROUP_MEMBER")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyGroupMember {

    @Id
    @Column(name="MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(name="MEMBER_ENROLLED_AT")
    private Timestamp memberEnrolledAt;

    @Column(name="MEMBER_WITHDRAWN_AT")
    private Timestamp memberWithdrawnAt;

    @Enumerated(EnumType.STRING)
    @Column(name="MEMBER_STATUS")
    private StudyGroupMemberStatus memberStatus;

    @Column(name="USER_ID")
    private Long userId;

    @Column(name="GROUP_ID")
    private Long groupId;

}
