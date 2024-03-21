package kr.hs.dge.dgsw.ex1.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_reply")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class ReplyEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;
    @Column(nullable = false)
    private String Text;
    @Column(nullable = false)
    private String replyer;

    @ManyToOne
    private BoardEntity board;

}
