package kr.hs.dge.dgsw.ex1.jwt;

import kr.hs.dge.dgsw.ex1.jwt.properties.JwtProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtUtilTest {
    @Autowired
    private JwtUtil jwtUtil;

    @Test
    void test() {
        String accessToken = jwtUtil.generateAccessToken("user1@aaa.com");
        System.out.println(accessToken);

        String refreshToken = jwtUtil.generateRefreshToken("user1@aaa.com");
        System.out.println(refreshToken);
    }
}