package com.springcooler.sgma.user.command.application.service;

import com.springcooler.sgma.user.command.domain.aggregate.UserEntity;

public interface UserService{
    UserEntity deactivateUser(Long userId);
    UserEntity activateUser(Long userId);
}
