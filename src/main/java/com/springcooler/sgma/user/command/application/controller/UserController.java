package com.springcooler.sgma.user.command.application.controller;

import com.springcooler.sgma.user.common.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import com.springcooler.sgma.user.command.application.service.UserService;
import com.springcooler.sgma.user.command.domain.aggregate.UserEntity;

@RestController("userCommandController")
@RequestMapping("/api/users")
public class UserController {
    private Environment env;
    private UserService userService;

    @Autowired
    public UserController(Environment env, UserService userService) {
        this.env = env;
        this.userService = userService;
    }

    @GetMapping("/health")
    public String status() {
        return "I'm Working in User Service on port " + env.getProperty("local.server.port");
    }

    @PatchMapping("/{userId}/deactivate")
    public ResponseDTO<?> deactivateUser(@PathVariable Long userId) {
        UserEntity userEntity = userService.deactivateUser(userId);
        return ResponseDTO.ok(userEntity);
    }

    @PatchMapping("/{userId}/activate")
    public ResponseDTO<?> activateUser(@PathVariable Long userId) {
        UserEntity userEntity = userService.activateUser(userId);
        return ResponseDTO.ok(userEntity);
    }

}
