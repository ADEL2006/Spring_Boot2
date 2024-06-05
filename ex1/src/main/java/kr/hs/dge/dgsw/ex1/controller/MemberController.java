package kr.hs.dge.dgsw.ex1.controller;

import kr.hs.dge.dgsw.ex1.dto.Member;
import kr.hs.dge.dgsw.ex1.dto.MemberProfileResponse;
import kr.hs.dge.dgsw.ex1.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    @GetMapping("/profile")
    public ResponseEntity profile(@AuthenticationPrincipal CustomUserDetails customUserDetails){
        Member member = customUserDetails.getMember();
        return ResponseEntity.ok(
                MemberProfileResponse.builder()
                        .email(member.getEmail())
                        .name(member.getName())
                        .role(member.getRole().name())
                        .build()
        );
    }

}
