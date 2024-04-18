package kr.hs.dge.dgsw.ex1.entity;

import jakarta.persistence.*;
import kr.hs.dge.dgsw.ex1.entity.enums.MemberRole;
import lombok.*;

@Entity
@Table(name = "tbl_member")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@ToString
public class MemberEntity extends BaseEntity {
    @Id
    private String email;
    private String password;
    private String name;

    @Enumerated(value = EnumType.STRING)
    private MemberRole role;
}
