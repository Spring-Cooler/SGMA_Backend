package com.springcooler.sgma.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.security.oauth2.client.registration")
public class OAuthProperties {

    private OAuthClient kakao;
    private OAuthClient naver;

    public static class OAuthClient {
        private String clientId;
        private String clientSecret;
        private String redirectUri;

        // Getters and Setters
        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getClientSecret() {
            return clientSecret;
        }

        public void setClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
        }

        public String getRedirectUri() {
            return redirectUri;
        }

        public void setRedirectUri(String redirectUri) {
            this.redirectUri = redirectUri;
        }
    }

    public OAuthClient getKakao() {
        return kakao;
    }

    public void setKakao(OAuthClient kakao) {
        this.kakao = kakao;
    }

    public OAuthClient getNaver() {
        return naver;
    }

    public void setNaver(OAuthClient naver) {
        this.naver = naver;
    }
}
