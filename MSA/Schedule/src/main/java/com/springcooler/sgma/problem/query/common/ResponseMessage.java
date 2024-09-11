package com.springcooler.sgma.problem.query.common;

import lombok.*;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseMessage {
    private int httpStatusCode;
    private String message;
    private Map<String, Object> result;


}
