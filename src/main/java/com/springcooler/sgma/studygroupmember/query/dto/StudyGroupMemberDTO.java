package com.springcooler.sgma.studygroupmember.query.dto;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyGroupMemberDTO {
    private long memberId;
    private Timestamp memberEnrolledAt;
    private Timestamp memberWithdrawnAt;
    private String memberStatus;
    private long userId;
    private long groupId;
}
