package com.springcooler.sgma.user.command.application.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RequestUpdateUserVO {
    @JsonProperty("nickname")
    private String nickname;

    @JsonProperty("profile_image")
    private String profileImage;
}