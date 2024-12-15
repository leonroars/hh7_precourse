package com.hhp.precourse.util.auth;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import javax.crypto.SecretKey;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    @Value("${spring.application.name}")
    private String issuer;
    @Value("${service.jwt.access-expiration}")
    private Long accessExpiration;
    @Value("${service.jwt.refresh-expiration}")
    private Long refreshExpiration;
    @Value("${service.jwt.secret-key}")
    private String key;
    private SecretKey secretKey;

    public enum TokenType {
        ACCESS, REFRESH
    }

    /**
     * @PostConstruct 이용해 JWT 서명에 활용될 대칭 암호키 생성.
     */
    @PostConstruct
    public void init() {
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
    }

    public String createAccessToken(Long memberId){

    }

}
