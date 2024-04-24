package kr.hs.dge.dgsw.ex1.dto;

import kr.hs.dge.dgsw.ex1.entity.enums.MemberRole;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Member {
    private String email;
    private String password;
    private String name;
    private MemberRole role;
}
