package com.springcooler.sgma.studygroupmember.query.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("member_status")
    private String memberStatus;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("group_id")
    private Long groupId;

}
