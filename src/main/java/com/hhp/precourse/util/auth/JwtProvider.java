package com.hhp.precourse.util.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.SIG;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
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

    /**
     * JWT : Access Token 생성 후 반환.
     * @param memberId
     * @return
     */
    public String createAccessToken(Long memberId){
        Date now = new Date();
        Date expireAt = new Date(now.getTime() + accessExpiration);

        return Jwts.builder()
                .id(UUID.randomUUID().toString())
                .issuer(issuer)
                .subject(memberId.toString())
                .issuedAt(now)
                .expiration(expireAt)
                .signWith(secretKey, SIG.HS512)
                .compact();
    }

}
