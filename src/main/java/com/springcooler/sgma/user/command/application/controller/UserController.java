package com.springcooler.sgma.user.command.application.controller;

import com.springcooler.sgma.user.command.domain.aggregate.vo.ResponseUserVO;
import com.springcooler.sgma.user.command.domain.aggregate.vo.RequestUpdateUserVO;
import com.springcooler.sgma.user.common.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import com.springcooler.sgma.user.command.application.service.UserService;
import com.springcooler.sgma.user.command.domain.aggregate.UserEntity;
import org.modelmapper.ModelMapper;

@RestController("userCommandController")
@RequestMapping("/api/users")
public class UserController {
    private final Environment env;
    private final UserService userService;
    private final ModelMapper modelMapper;
    @Autowired
    public UserController(Environment env, UserService userService,ModelMapper modelMapper) {
        this.env = env;
        this.userService = userService;
        this.modelMapper=modelMapper;
    }

    @GetMapping("/health")
    public String status() {
        return "I'm Working in User Service on port "
                + env.getProperty("local.server.port");
    }

    //필기. 사용자 활성화 여부 변경
    @PatchMapping("/{userId}/deactivate")
    public ResponseDTO<?> deactivateUser(@PathVariable Long userId) {
        UserEntity userEntity = userService.deactivateUser(userId);
        return ResponseDTO.ok(userEntity);
    }
    //필기. 사용자 활성화 여부 변경
    @PatchMapping("/{userId}/activate")
    public ResponseDTO<?> activateUser(@PathVariable Long userId) {
        UserEntity userEntity = userService.activateUser(userId);
        return ResponseDTO.ok(userEntity);
    }
    //필기. 사용자 정보 변경(닉네임,사진)
    @PatchMapping("/{userId}/profile")
    public ResponseDTO<?> updateProfile(@PathVariable Long userId,
                                        @RequestBody RequestUpdateUserVO userUpdateDTO) {
        UserEntity userEntity = userService.updateProfile(userId, userUpdateDTO);
        ResponseUserVO userUpdateRequestVO= modelMapper.map(userEntity, ResponseUserVO.class);
        return ResponseDTO.ok(userUpdateRequestVO);
    }

}
