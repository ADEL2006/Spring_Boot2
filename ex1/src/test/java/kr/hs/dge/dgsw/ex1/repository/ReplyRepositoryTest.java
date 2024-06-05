package kr.hs.dge.dgsw.ex1.repository;

import kr.hs.dge.dgsw.ex1.entity.BoardEntity;
import kr.hs.dge.dgsw.ex1.entity.ReplyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTest {
    @Autowired
    private ReplyRepository replyRepository;

    @Test
    void testList() {
        BoardEntity boardEntity = BoardEntity.builder().bno(3L).build();

        List<ReplyEntity> result = replyRepository.findByBoardOrderByRno(boardEntity);

        result.forEach(replyEntity -> System.out.println(replyEntity));
    }

    @Test
    void testInsert() {
        IntStream.rangeClosed(1, 300)
                .forEach(i -> {
                    long bno = (long) (Math.random() * 100) + 1; // 1~100
                    BoardEntity boardEntity = BoardEntity.builder()
                            .bno(bno).build(); // board entity
                    ReplyEntity replyEntity = ReplyEntity.builder()
                            .text("Reply .... " + i)
                            .replyer("guest")
                            .board(boardEntity).build(); //replay entity
                    replyRepository.save(replyEntity);
                });
    }
}
