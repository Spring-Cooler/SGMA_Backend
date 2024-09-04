package com.springcooler.sgma.studygroupapplicant.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommonException extends RuntimeException{
    private final ErrorCode errorCode;
    //필기. 에러 발생시 ErroCode별 메시지
    @Override
    public String getMessage() {
        return this.errorCode.getMessage();
    }

}