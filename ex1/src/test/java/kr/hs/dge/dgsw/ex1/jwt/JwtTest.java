package kr.hs.dge.dgsw.ex1.jwt;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class JwtTest {
//    https://jwt.io/#debugger-io
    @Autowired
    private JwtUtil jwtUtil;

    @Test
    void test() {
        String accessToken = jwtUtil.generateAccessToken("user1@aaa.com");
        System.out.println(accessToken);
        System.out.println();
        String refreshToken = jwtUtil.generateRefreshToken("user1@aaa.com");
        System.out.println(refreshToken);
    }

    @Test
    void testClaims() {
        String accessToken = jwtUtil.generateAccessToken("user1@aaa.com");

        Claims claims = jwtUtil.getClaims(accessToken);

        System.out.println(claims.getSubject());
    }

}