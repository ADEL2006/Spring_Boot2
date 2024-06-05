package kr.hs.dge.dgsw.ex1.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@Builder
public class MemberProfileResponse {
    private String email;
    private String name;
    private String role;
}
