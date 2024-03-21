package kr.hs.dge.dgsw.ex1.repository;

import kr.hs.dge.dgsw.ex1.entity.MemberEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void testInsert() {
        IntStream
                .rangeClosed(1, 100)
                .forEach(i -> {
                    MemberEntity memberEntity = MemberEntity.builder()
                            .email("user" + i + "@aaa.com")
                            .password("1234")
                            .name("USER" + i)
                            .build();
                    memberRepository.save(memberEntity);
                });
    }
}