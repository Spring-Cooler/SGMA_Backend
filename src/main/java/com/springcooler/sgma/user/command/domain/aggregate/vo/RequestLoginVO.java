package com.springcooler.sgma.user.command.domain.aggregate.vo;

import lombok.Data;

@Data
public class RequestLoginVO {
    private String email;
    private String password;
}
