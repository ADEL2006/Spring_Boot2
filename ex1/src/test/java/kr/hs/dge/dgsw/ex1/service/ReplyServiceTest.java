package kr.hs.dge.dgsw.ex1.service;

import kr.hs.dge.dgsw.ex1.dto.ReplyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyServiceTest {
    @Autowired
    private ReplyService replyService;

    @Test
    void testRegister() {
        ReplyDTO.builder()
                .bno(2L)
                .text("test!!!")
                .replyer("replyer")
                .build();
    }
}