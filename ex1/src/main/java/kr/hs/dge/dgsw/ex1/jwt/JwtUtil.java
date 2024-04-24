package kr.hs.dge.dgsw.ex1.jwt;

import kr.hs.dge.dgsw.ex1.dto.Member;
import kr.hs.dge.dgsw.ex1.jwt.properties.JwtProperties;
import kr.hs.dge.dgsw.ex1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final JwtProperties jwtProperties;
    private final MemberRepository memberRepository;

    public String generateAccessToken(String email) {
        return 
    }
}
