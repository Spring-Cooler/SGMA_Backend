package com.springcooler.sgma.user.command.application.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseUserVO {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("password")
    private String password;

    @JsonProperty("nickname")
    private String nickname;

    @JsonProperty("email")
    private String email;

    @JsonProperty("user_status")
    private String userStatus;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("withdrawn_at")
    private String withdrawnAt;

    @JsonProperty("profile_image")
    private String profileImage;

    @JsonProperty("accept_status")
    private String acceptStatus;

    @JsonProperty("signup_path")
    private String signupPath;
}
