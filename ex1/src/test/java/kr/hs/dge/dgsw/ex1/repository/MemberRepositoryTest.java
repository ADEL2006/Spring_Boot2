package kr.hs.dge.dgsw.ex1.repository;

import kr.hs.dge.dgsw.ex1.entity.MemberEntity;
import kr.hs.dge.dgsw.ex1.entity.enums.MemberRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void testInsert() {
        IntStream
                .rangeClosed(1, 100)
                .forEach(i -> {
                    MemberEntity memberEntity = MemberEntity.builder()
                            .email("user" + i + "@aaa.com")
                            .password(passwordEncoder.encode("1234"))
                            .name("USER" + i)
                            .role(MemberRole.USER)
                            .build();
                    memberRepository.save(memberEntity);
                });
    }
}