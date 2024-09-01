package com.springcooler.sgma.user.command.application.service;

import com.springcooler.sgma.user.command.domain.aggregate.ActiveStatus;
import com.springcooler.sgma.user.command.domain.aggregate.vo.RequestUpdateUserVO;
import com.springcooler.sgma.user.command.domain.aggregate.UserEntity;
import com.springcooler.sgma.user.command.domain.repository.UserRepository;
import com.springcooler.sgma.user.common.exception.CommonException;
import com.springcooler.sgma.user.common.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceImplTests {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("사용자 비활성화 성공 테스트")
    void deactivateUser_Success() {
        // Given
        Long userId = 1L;  // 실제 DB에 존재하는 사용자 ID로 변경 필요
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_USER));

        // When
        UserEntity result = userServiceImpl.deactivateUser(userId);

        // Then
        assertNotNull(result);
        assertEquals(ActiveStatus.INACTIVE, result.getUserStatus());
        assertNotNull(result.getWithdrawnAt());
    }

    @Test
    @DisplayName("존재하지 않는 사용자 비활성화 실패 테스트")
    void deactivateUser_UserNotFound() {
        // Given
        Long userId = 999L;  // 존재하지 않는 사용자 ID로 테스트

        // When & Then
        CommonException exception = assertThrows(CommonException.class, () -> userServiceImpl.deactivateUser(userId));
        assertEquals(ErrorCode.NOT_FOUND_USER, exception.getErrorCode());
    }

    @Test
    @DisplayName("사용자 활성화 성공 테스트")
    void activateUser_Success() {
        // Given
        Long userId = 1L;  // 실제 DB에 존재하는 사용자 ID로 변경 필요
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_USER));

        // When
        UserEntity result = userServiceImpl.activateUser(userId);

        // Then
        assertNotNull(result);
        assertEquals(ActiveStatus.ACTIVE, result.getUserStatus());
    }

    @Test
    @DisplayName("존재하지 않는 사용자 활성화 실패 테스트")
    void activateUser_UserNotFound() {
        // Given
        Long userId = 999L;  // 존재하지 않는 사용자 ID로 테스트

        // When & Then
        CommonException exception = assertThrows(CommonException.class, () -> userServiceImpl.activateUser(userId));
        assertEquals(ErrorCode.NOT_FOUND_USER, exception.getErrorCode());
    }

    @Test
    @DisplayName("사용자 비활성화 시간 정확성 검증 테스트")
    void deactivateUser_TimeExactMatchVerification() {
        // Given
        Long userId = 1L;  // 실제 DB에 존재하는 사용자 ID로 변경 필요
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_USER));

        // When
        UserEntity result = userServiceImpl.deactivateUser(userId);

        // Then
        assertNotNull(result);
        assertEquals(ActiveStatus.INACTIVE, result.getUserStatus());

        // 현재 시간을 기준으로 withdrawnAt이 정확히 같은지 확인 (초 단위까지)
        LocalDateTime now = LocalDateTime.now().withNano(0);
        LocalDateTime withdrawnAt = result.getWithdrawnAt();
        assertNotNull(withdrawnAt);
        assertTrue(ChronoUnit.SECONDS.between(withdrawnAt, now) < 1,
                "withdrawnAt 시간이 현재 시간과 1초 이내여야 합니다.");
    }

    @Test
    @DisplayName("사용자 프로필 업데이트 성공 테스트")
    void updateProfile_Success() {
        // Given
        Long userId = 1L;
        RequestUpdateUserVO userUpdateVO = new RequestUpdateUserVO();
        userUpdateVO.setNickname("새로운 닉네임");
        userUpdateVO.setProfileImage("new_image_url");

        // When
        UserEntity result = userServiceImpl.updateProfile(userId, userUpdateVO);

        // Then
        assertNotNull(result);
        assertEquals("새로운 닉네임", result.getNickname());
        assertEquals("new_image_url", result.getProfileImage());
    }

    @Test
    @DisplayName("존재하지 않는 사용자 프로필 업데이트 실패 테스트")
    void updateProfile_UserNotFound() {
        // Given
        Long userId = 999L;  // 존재하지 않는 사용자 ID로 테스트
        RequestUpdateUserVO userUpdateVO = new RequestUpdateUserVO();
        userUpdateVO.setNickname("새로운 닉네임");
        userUpdateVO.setProfileImage("new_image_url");

        // When & Then
        CommonException exception = assertThrows(CommonException.class, () -> userServiceImpl.updateProfile(userId, userUpdateVO));
        assertEquals(ErrorCode.NOT_FOUND_USER, exception.getErrorCode());
    }
}
