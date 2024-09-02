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
    private String encryptedPwd;

    @Column(name = "nickname", length = 255)
    private String nickname;

    @Column(name = "email", length = 255)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status", nullable = false, length = 255)
    private ActiveStatus userStatus =  ActiveStatus.ACTIVE;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "withdrawn_at")
    private LocalDateTime withdrawnAt;

    @Column(name = "profile_image", columnDefinition = "TEXT")
    private String profileImage;

    @Enumerated(EnumType.STRING)
    @Column(name = "accept_status", nullable = false, length = 255)
    private AcceptStatus acceptStatus = AcceptStatus.N;

    @Enumerated(EnumType.STRING)
    @Column(name = "signup_path", length = 255)
    private SignupPath signupPath;

    @Column(name = "user_identifier", nullable = false, unique = true, length = 511)
    private String userIdentifier; // 신규 추가

    @PrePersist
    public void prePersist() {
        // userIdentifier를 signupPath와 email을 기반으로 생성
        this.userIdentifier = this.signupPath + "_" + this.email;
    }

    public void deactivateUser() {
        this.userStatus = ActiveStatus.INACTIVE;
        this.withdrawnAt = LocalDateTime.now().withNano(0);
    }

    public void activateUser() {
        this.userStatus = ActiveStatus.ACTIVE;
        this.withdrawnAt = null;
    }

    public void updateProfile(String nickname, String profileImage) {
        if (nickname != null && !nickname.isEmpty()) {
            this.nickname = nickname;
        }
        if (profileImage != null && !profileImage.isEmpty()) {
            this.profileImage = profileImage;
        }
    }
}
