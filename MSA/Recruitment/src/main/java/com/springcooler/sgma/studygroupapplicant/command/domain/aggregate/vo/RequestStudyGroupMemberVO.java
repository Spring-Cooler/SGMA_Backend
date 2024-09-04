package com.springcooler.sgma.studygroupapplicant.command.domain.aggregate.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RequestStudyGroupMemberVO {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("group_id")
    private Long groupId;

}
