package kr.hs.dge.dgsw.ex1.service;

import kr.hs.dge.dgsw.ex1.dto.AuthenticationRequest;
import kr.hs.dge.dgsw.ex1.dto.JsonWebTokenResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthServiceTest {
    @Autowired
    private AuthService authService;

    @Test
    void test() {
        AuthenticationRequest request = new AuthenticationRequest();
        request.setEmail("user100@aaa.com");
        request.setPassword("1234");

        JsonWebTokenResponse jsonWebTokenResponse = authService.auth(request);

        System.out.println(jsonWebTokenResponse.getAccessToken());
        System.out.println();
        System.out.println(jsonWebTokenResponse.getRefreshToken());
    }

    @Test
    void testRefreshToken() {
        String refreshToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMTAwQGFhYS5jb20iLCJpYXQiOjE3MTUxNDczMDIsImV4cCI6MTcxNTIzMzcwMn0.PWx1LjHKHDISsdQ6LGuRSMILf9I8G0Sbdmk8alqukIg";
        JsonWebTokenResponse refresh = authService.refresh(refreshToken);
        System.out.println(refresh.getAccessToken());
    }
}



