package com.springcooler.sgma.user.command.domain.aggregate.vo.kakao;

public class KakaoUser {
    private String id;           // 사용자 고유번호
    private String email;        // 사용자 이메일
    private String realName;     // 사용자 실명

    // 생성자
    public KakaoUser(String id, String email, String realName) {
        this.id = id;
        this.email = email;
        this.realName = realName;
    }

    // Getter 및 Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "KakaoUser{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
