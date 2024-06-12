package kr.hs.dge.dgsw.ex1.entity.movie;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tbl_review")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = "")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;
    
    private int grade;
    private String text;


}
