package kr.hs.dge.dgsw.ex1.dto;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class ReplyDTO {
    private Long rno;
    private String text;
    private String replyer;
    private Long bno;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
