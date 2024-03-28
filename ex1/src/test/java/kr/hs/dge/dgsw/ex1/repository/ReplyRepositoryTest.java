package kr.hs.dge.dgsw.ex1.repository;

import kr.hs.dge.dgsw.ex1.entity.BoardEntity;
import kr.hs.dge.dgsw.ex1.entity.ReplyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTest {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    void tsetInsert() {
        IntStream.rangeClosed(1, 100)
                .forEach(i -> {
                    long bno = (long) (Math.random() * 100) + 1; // 1~100
                    BoardEntity boardEntity = BoardEntity.builder()
                            .bno(bno)
                            .build();
                    ReplyEntity replyEntity = ReplyEntity.builder()
                            .text("Reply .... " + i)
                            .replyer("guest")
                            .board(boardEntity)
                            .build();
                    replyRepository.save(replyEntity);
                });
    }
}
