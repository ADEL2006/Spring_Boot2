package kr.hs.dge.dgsw.ex1.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
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

    public Claims getClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new IllegalArgumentException("Expired JWT token");
        } catch (UnsupportedJwtException e) {
            throw new IllegalArgumentException("Unsupported JWT token");
        } catch (MalformedJwtException e) {
            throw new IllegalArgumentException("Invalid JWT token");
        } catch (SignatureException e) {
            throw new IllegalArgumentException("Invalid JWT token");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("JWT claims string is empty");
        }
    }
}