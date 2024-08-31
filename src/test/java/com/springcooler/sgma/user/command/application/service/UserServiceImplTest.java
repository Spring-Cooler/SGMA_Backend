package com.springcooler.sgma.user.command.application.service;

import com.springcooler.sgma.user.command.domain.aggregate.UserEntity;
import com.springcooler.sgma.user.command.domain.repository.UserRepository;
import com.springcooler.sgma.user.common.exception.CommonException;
import com.springcooler.sgma.user.common.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceImplTest {

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
        assertEquals("INACTIVE", result.getUserStatus());
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
        assertEquals("ACTIVE", result.getUserStatus());
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
}
