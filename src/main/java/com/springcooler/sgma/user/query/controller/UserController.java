package com.springcooler.sgma.user.query.controller;

import com.springcooler.sgma.user.common.ResponseDTO;
import com.springcooler.sgma.user.query.dto.UserDTO;
import com.springcooler.sgma.user.query.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final Environment env;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserController(Environment env, ModelMapper modelMapper, UserService userService) {
        this.env = env;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    // 사용자 ID로 조회
    @GetMapping("/userId/{userId}")
    public ResponseDTO<?> getUserById(@PathVariable Long userId) {
        UserDTO userDTO = userService.getUserByuUserId(userId);
        return ResponseDTO.ok(userDTO);
    }

    // 이전의 이름으로 조회하는 메서드
    @GetMapping("/nickname/{nickname}")
    public ResponseDTO<UserDTO> getUserByName(@PathVariable String nickname) {
        UserDTO userDTO = userService.getUserByNickname(nickname);
        return ResponseDTO.ok(userDTO);
    }
}
