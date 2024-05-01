package kr.hs.dge.dgsw.ex1.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kr.hs.dge.dgsw.ex1.dto.Member;
import kr.hs.dge.dgsw.ex1.jwt.properties.JwtProperties;
import kr.hs.dge.dgsw.ex1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final JwtProperties jwtProperties;
    private final MemberRepository memberRepository;

    public String generateAccessToken(String email) {
        String accessToken = Jwts.builder()
                .setSubject(email) // username
                .setIssuedAt(new Date(System.currentTimeMillis())) // 발행 시간
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration())) // 만료 시간
                .signWith(SignatureAlgorithm.HS384, jwtProperties.getSecretKey())
                .compact();
        return accessToken;
    }

    public String generateRefreshToken(String email) {
        String refreshToken = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(
                        new Date(
                                System.currentTimeMillis() + jwtProperties.getRefreshExpiration()
                        )
                )
                .signWith(SignatureAlgorithm.HS384, jwtProperties.getSecretKey())
                .compact();
        return refreshToken;
    }
}