package com.springcooler.sgma.user.query.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RequestUserIdentifierDTO {
    @JsonProperty("user_identifier")
    private String userIdentifier; // 변경, 가입 경로 + 사용자id 조합
}
