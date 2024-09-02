package com.springcooler.sgma.studygroupmember.command.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springcooler.sgma.studygroupmember.command.domain.aggregate.StudyGroupMemberStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyGroupMemberDTO {

    @JsonProperty("member_id")
    private Long memberId;

    @JsonProperty("member_enrolled_at")
    private Timestamp memberEnrolledAt;

    @JsonProperty("member_withdrawn_at")
    private Timestamp memberWithdrawnAt;

    @Enumerated(EnumType.STRING)
    @JsonProperty("member_status")
    private StudyGroupMemberStatus memberStatus;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("group_id")
    private Long groupId;

}
