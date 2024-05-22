package kr.hs.dge.dgsw.ex1.controller;

import kr.hs.dge.dgsw.ex1.dto.Member;
import kr.hs.dge.dgsw.ex1.security.MemberSecurity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sample")
@Slf4j
public class SampleController {

    private final MemberSecurity memberSecurity;

    @GetMapping("/test1")
    public void test1() {
        Member member = memberSecurity.getMember();
        log.info("Member: {}", member);
    }
}
