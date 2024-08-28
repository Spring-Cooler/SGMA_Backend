package com.springcooler.sgma.studygroupmember.query.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyGroupMemberDTO {
    private long memberId;
    private LocalDateTime memberEnrolledAt;
    private LocalDateTime memberWithdrawnAt;
    private String memberStatus;
    private long userId;
    private long groupId;
}
