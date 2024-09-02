package com.springcooler.sgma.user.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "USER")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name", nullable = false, length = 255)
    private String userName;

    @Column(name = "password", length = 255)
//    private String pwd;
    private String encryptedPwd; //암호화 이후의 컬럼

    @Column(name = "nickname", length = 255)
    private String nickname;

    @Column(name = "email", length = 255)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status", nullable = false, length = 255)
    private ActiveStatus userStatus =  ActiveStatus.ACTIVE; //필기. Enum타입으로 정의

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "withdrawn_at")
    private LocalDateTime withdrawnAt;

    @Column(name = "profile_image", columnDefinition = "TEXT")
    private String profileImage;

    @Enumerated(EnumType.STRING)
    @Column(name = "accept_status", nullable = false, length = 255)
    private AcceptStatus acceptStatus = AcceptStatus.N;  //필기. Enum타입으로 정의

    @Enumerated(EnumType.STRING)
    @Column(name = "signup_path", length = 255)
    private SignupPath signupPath; //필기. Enum타입으로 정의

    // 사용자 정보 비활성화로 설정
    public void deactivateUser() {
        this.userStatus = ActiveStatus.INACTIVE;
        this.withdrawnAt = LocalDateTime.now().withNano(0); // 필기. 초 단위까지만 설정
    }

    // 사용자 정보 활성화로 설정
    public void activateUser() {
        this.userStatus = ActiveStatus.ACTIVE;
        this.withdrawnAt = null; // 재활성화 시 탈퇴 시간을 초기화
    }

    // 사용자 정보 변경(닉네임, 사진)
    public void updateProfile(String nickname, String profileImage) {
        if (nickname != null && !nickname.isEmpty()) {
            this.nickname = nickname;
        }
        if (profileImage != null && !profileImage.isEmpty()) {
            this.profileImage = profileImage;
        }
    }
}
