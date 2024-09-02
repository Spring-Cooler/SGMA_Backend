package com.springcooler.sgma.user.command.application.controller;

import com.springcooler.sgma.user.command.application.dto.RequestUpdateUserDTO;
import com.springcooler.sgma.user.command.application.dto.UserDTO;
import com.springcooler.sgma.user.command.domain.aggregate.vo.RequestResistUserVO;
import com.springcooler.sgma.user.command.domain.aggregate.vo.ResponseUserVO;
import com.springcooler.sgma.user.common.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import com.springcooler.sgma.user.command.application.service.UserService;
import com.springcooler.sgma.user.command.domain.aggregate.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

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
    public ResponseDTO<?> deactivateUser(@PathVariable("userId") Long userId) {
        UserEntity userEntity = userService.deactivateUser(userId);
        return ResponseDTO.ok(userEntity);
    }
    //필기. 사용자 활성화 여부 변경
    @PatchMapping("/{userId}/activate")
    public ResponseDTO<?> activateUser(@PathVariable("userId") Long userId) {
        UserEntity userEntity = userService.activateUser(userId);
        return ResponseDTO.ok(userEntity);
    }

    //필기. 사용자 정보 변경(닉네임,사진)
    @PatchMapping("/{userId}/profile")
    public ResponseDTO<?> updateProfile(@PathVariable("userId") Long userId,
                                        @RequestParam("nickname") String nickname,
                                        @RequestParam("profile_image") MultipartFile profileImage) {

        // DTO 객체 생성 및 값 설정
        RequestUpdateUserDTO userUpdateDTO = new RequestUpdateUserDTO();
        userUpdateDTO.setNickname(nickname);
        userUpdateDTO.setProfileImage(profileImage);

        // 서비스 호출 및 결과 처리
        UserEntity userEntity = userService.updateProfile(userId, userUpdateDTO);
        ResponseUserVO userUpdateRequestVO = modelMapper.map(userEntity, ResponseUserVO.class);
        return ResponseDTO.ok(userUpdateRequestVO);
    }

    /*설명. 일반 회원 가입 기능*/
    @PostMapping("/normal")
    public ResponseDTO<?> registNormalUser(@RequestBody RequestResistUserVO newUser) {
        UserDTO userDTO = modelMapper.map(newUser, UserDTO.class);

        // signupPath 설정
        userDTO.setSignupPath(newUser.getSignupPath());

        // createdAt 현재 시각으로 설정
        userDTO.setCreatedAt(LocalDateTime.now().withNano(0));

        // UserService 호출
        UserDTO savedUserDTO = userService.registUser(userDTO); // 저장된 DTO 반환

        ResponseUserVO responseUser=modelMapper.map(savedUserDTO,ResponseUserVO.class);
        return ResponseDTO.ok(responseUser);
    }

}