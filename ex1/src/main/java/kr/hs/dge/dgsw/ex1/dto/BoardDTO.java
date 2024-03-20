package kr.hs.dge.dgsw.ex1.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class BoardDTO {
    private Long bno;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
}
