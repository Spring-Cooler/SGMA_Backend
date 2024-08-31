package com.springcooler.sgma.user.command.application.service;

import com.springcooler.sgma.user.command.domain.aggregate.UserEntity;
import com.springcooler.sgma.user.command.domain.repository.UserRepository;
import com.springcooler.sgma.user.common.exception.CommonException;
import com.springcooler.sgma.user.common.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userCommandServiceImpl")
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserEntity deactivateUser(Long userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new CommonException(ErrorCode.NOT_FOUND_USER);
        }
        UserEntity userEntity = user.get();
        userEntity.deactivateUser();
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity activateUser(Long userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new CommonException(ErrorCode.NOT_FOUND_USER);
        }
        UserEntity userEntity = user.get();
        userEntity.activateUser();
        return userRepository.save(userEntity);
    }

}