package com.springcooler.sgma.user.query.service;

import com.springcooler.sgma.user.query.dto.UserDTO;
import com.springcooler.sgma.user.query.repository.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO getUserByuUserId(Long userId) {
        return userMapper.findByUserId(userId);
    }

    @Override
    public UserDTO getUserByNickname(String nickname) {
        return userMapper.findByNickname(nickname);
    }
}
