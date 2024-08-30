package com.springcooler.sgma.studygroupnotice.query.common;

import lombok.*;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseMessage {
    private int httpStatus;                 // 응답 상태 코드
    private String message;                 // 응답 메세지
    private Map<String, Object> result;     // 응답 데이터
}
