package kr.hs.dge.dgsw.ex1.service;

import kr.hs.dge.dgsw.ex1.dto.ReplyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyServiceTest {
    @Autowired
    private ReplyService replyService;

    @Test
    void testResiter() {
        ReplyDTO replyDTO = ReplyDTO.builder()
                .bno(9L)
                .text("test!!!")
                .replyer("replyer")
                .build();
        replyService.register(replyDTO);
    }

    @Test
    void testList() {
        List<ReplyDTO> result = replyService.getList(2L);
        result.forEach(dto -> {
            System.out.println(dto);
        });
    }
}