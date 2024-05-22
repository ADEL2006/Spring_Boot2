package kr.hs.dge.dgsw.ex1.controller;

import kr.hs.dge.dgsw.ex1.dto.Member;
import kr.hs.dge.dgsw.ex1.security.CustomUserDetails;
import kr.hs.dge.dgsw.ex1.security.MemberSecurity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

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

    @GetMapping("/test2")
    public void test2(Principal principal) {
        log.info(".................... username: {}", principal.getName());
    }

    @GetMapping("/test3")
    public void test3(Authentication authentication) {
        Member member = ((CustomUserDetails) authentication.getPrincipal()).getMember();
        log.info("................. Member: ", member);
    }
}
