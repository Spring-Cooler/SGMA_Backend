package com.springcooler.sgma.studygroupapplicant.command.domain.aggregate.vo;

import lombok.Data;

@Data
public class RequestStudyGroupMemberVO {
    private Long userId;
    private Long groupId;
}
