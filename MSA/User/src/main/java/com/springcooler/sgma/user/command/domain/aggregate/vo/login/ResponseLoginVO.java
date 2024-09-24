package com.springcooler.sgma.user.command.domain.aggregate.vo.login;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseLoginVO {

    @JsonProperty("access_token") // 스네이크 케이스로 변환
    private String accessToken;

    @JsonProperty("access_token_expiry")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Date accessTokenExpiry;

    @JsonProperty("refresh_token") // 스네이크 케이스로 변환
    private String refreshToken;

    @JsonProperty("refresh_token_expiry")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Date refreshTokenExpiry;

    @JsonProperty("user_identifier") // 스네이크 케이스로 변환
    private String userIdentifier;
}
