package com.springcooler.sgma.studygroupmember.command.domain.aggregate;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
    @JsonProperty("member_id")
    private Long memberId;

    @Column(name="MEMBER_ENROLLED_AT")
    @JsonProperty("member_enrolled_at")
    private LocalDateTime memberEnrolledAt;

    @Column(name="MEMBER_WITHDRAWN_AT")
    @JsonProperty("member_withdrawn_at")
    private LocalDateTime memberWithdrawnAt;

    @Enumerated(EnumType.STRING)
    @Column(name="MEMBER_STATUS")
    @JsonProperty("member_status")
    private StudyGroupMemberStatus memberStatus;

    @Column(name="USER_ID")
    @JsonProperty("user_id")
    private Long userId;

    @Column(name="GROUP_ID")
    @JsonProperty("group_id")
    private Long groupId;

    @Enumerated(EnumType.STRING)
    @Column(name="GROUP_ROLE")
    @JsonProperty("group_role")
    private GroupRole groupRole;

}
