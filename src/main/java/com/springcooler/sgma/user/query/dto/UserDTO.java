package com.springcooler.sgma.user.query.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Long userId;
    private String userName;
    private String password;
    private String nickname;
    private String email;
    private String userStatus;
    private Timestamp createdAt;
    private Timestamp withdrawnAt;
    private String profileImage;
    private String acceptStatus;
    private String signupPath;

    // 기본 생성자, 모든 필드를 포함한 생성자, 필요한 경우 빌더 패턴 등을 추가할 수 있습니다.
}