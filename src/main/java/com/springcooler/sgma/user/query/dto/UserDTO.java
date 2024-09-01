package com.springcooler.sgma.user.query.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springcooler.sgma.user.command.domain.aggregate.AcceptStatus;
import com.springcooler.sgma.user.command.domain.aggregate.ActiveStatus;
import com.springcooler.sgma.user.command.domain.aggregate.SignupPath;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class UserDTO {
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
    private ActiveStatus userStatus;  // Enum 타입으로 정의

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("withdrawn_at")
    private LocalDateTime withdrawnAt;

    @JsonProperty("profile_image")
    private String profileImage;

    @JsonProperty("accept_status")
    private AcceptStatus acceptStatus;  // Enum 타입으로 정의

    @JsonProperty("signup_path")
    private SignupPath signupPath;  // Enum 타입으로 정의
    // 기본 생성자, 모든 필드를 포함한 생성자, 필요한 경우 빌더 패턴 등을 추가할 수 있습니다.
}
