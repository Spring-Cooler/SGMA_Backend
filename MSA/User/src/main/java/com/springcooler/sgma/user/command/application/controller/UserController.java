package com.springcooler.sgma.user.command.application.controller;

import com.springcooler.sgma.user.command.application.dto.*;
import com.springcooler.sgma.user.command.application.service.EmailVerificationService;
import com.springcooler.sgma.user.command.domain.aggregate.AcceptStatus;
import com.springcooler.sgma.user.command.domain.aggregate.ActiveStatus;
import com.springcooler.sgma.user.command.domain.aggregate.SignupPath;
import com.springcooler.sgma.user.command.domain.aggregate.vo.RequestResistUserVO;
import com.springcooler.sgma.user.command.domain.aggregate.vo.RequestUpdatePasswordUserVO;
import com.springcooler.sgma.user.command.domain.aggregate.vo.ResponseEmailMessageVO;
import com.springcooler.sgma.user.command.domain.aggregate.vo.ResponseUserVO;
import com.springcooler.sgma.user.common.ResponseDTO;
import com.springcooler.sgma.user.common.exception.CommonException;
import com.springcooler.sgma.user.common.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;
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


    //필기. 사용자 비밀번호 재설정
    @PatchMapping("/{userId}/password")
    public ResponseDTO<?> updateProfile(@PathVariable("userId") Long userId,
                                        @RequestBody RequestUpdatePasswordUserVO requestUpdatePasswordUserVO) {

        // 서비스 호출 및 결과 처리
        UserEntity userEntity = userService.updatePassword(userId, requestUpdatePasswordUserVO.getPassword());
        ResponseUserVO userUpdateRequestVO = modelMapper.map(userEntity, ResponseUserVO.class);
        return ResponseDTO.ok(userUpdateRequestVO);
    }

    /*설명. 일반 회원 가입 기능*/
    @PostMapping("/signup/normal")
    public ResponseDTO<?> registNormalUser(@RequestBody RequestResistUserVO newUser) {

        // UserService 호출
        UserDTO savedUserDTO = userService.registUser(newUser); // 저장된 DTO 반환
        
        //응답 VO로 변환후 반환
        ResponseUserVO responseUser=modelMapper.map(savedUserDTO,ResponseUserVO.class);
        return ResponseDTO.ok(responseUser);
    }


    // 설명. 이메일 인증 서비스
    @Autowired
    private EmailVerificationService emailVerificationService;

    // 설명. 이메일 전송 API (회원가입전, 아이디 찾기시 실행)
    @PostMapping("/verification-email/signup")
    public ResponseDTO<?> sendVerificationEmail(@RequestBody @Validated EmailVerificationVO request) {
        emailVerificationService.sendVerificationEmail(request.getEmail());

        ResponseEmailMessageVO responseEmailMessageVO = new ResponseEmailMessageVO();
        responseEmailMessageVO.setMessage("인증 코드가 이메일로 전송되었습니다.");
        return ResponseDTO.ok(responseEmailMessageVO);
    }

    // 설명. 이메일 전송 API(아이디 찾기시 실행)
    @PostMapping("/verification-email/auth-id")
    public ResponseDTO<?> sendVerificationEmailForUserId(@RequestBody @Validated EmailVerificationUserIdRequestDTO request) {
        // 닉네임, 가입 구분, 이메일이 일치하는 사용자가 있는지 확인
        UserDTO user = userService.findUserByUserNicknameAndSignupPathAndEmail(request.getNickname(), SignupPath.NORMAL, request.getEmail());

        if (user == null) {
            throw new CommonException(ErrorCode.NOT_FOUND_USER);
        }

        // 유효성 검사후 가능하면 이메일 전송
        emailVerificationService.sendVerificationEmail(request.getEmail());

        ResponseEmailMessageVO responseEmailMessageVO = new ResponseEmailMessageVO();
        responseEmailMessageVO.setMessage("아이디 찾기를 위한 인증 코드가 이메일로 전송되었습니다.");
        return ResponseDTO.ok(responseEmailMessageVO);
    }

    // 설명. 이메일 전송 API (비밀번호 찾기시 실행)
    @PostMapping("/verification-email/user-password")
    public ResponseDTO<?> sendVerificationEmailForUserPassword(@RequestBody @Validated EmailVerificationUserPasswordRequestDTO request) {
        // NORMAL_{userAuthId}와 이메일이 일치하는 사용자가 있는지 확인
        UserDTO user = userService.findUserByUserAuthIdAndEmail(request.getUserAuthId(), request.getEmail());

        if (user == null) {
            throw new CommonException(ErrorCode.NOT_FOUND_USER);
        }

        // 유효성 검사후 가능하면 이메일 전송
        emailVerificationService.sendVerificationEmail(request.getEmail());

        ResponseEmailMessageVO responseEmailMessageVO = new ResponseEmailMessageVO();
        responseEmailMessageVO.setMessage("비밀번호 찾기를 위한 인증 코드가 이메일로 전송되었습니다.");
        return ResponseDTO.ok(responseEmailMessageVO);
    }


    //설명. 이메일 인증번호 검증 API (회원가입전 실행)
    @PostMapping("/verification-email/confirmation")
    public ResponseDTO<?> verifyEmail(@RequestBody @Validated EmailVerificationVO request) {
        boolean isVerified = emailVerificationService.verifyCode(request.getEmail(), request.getCode());

        ResponseEmailMessageVO responseEmailMessageVO =new ResponseEmailMessageVO();
        responseEmailMessageVO.setMessage("이메일 인증이 완료되었습니다.");
        if (isVerified) {
            return ResponseDTO.ok(responseEmailMessageVO);
        } else {
            return ResponseDTO.fail(new CommonException(ErrorCode.INVALID_VERIFICATION_CODE));
        }
    }

}