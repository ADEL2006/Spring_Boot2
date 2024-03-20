package kr.hs.dge.dgsw.ex1.repository;

import jakarta.persistence.Column;
import jakarta.transaction.Transactional;
import kr.hs.dge.dgsw.ex1.entity.BoardEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    void testInsert() {
        IntStream.rangeClosed(0, 100).forEach(i -> {
            BoardEntity boardEntity =
            BoardEntity.builder()
                    .title("title .... " + i)
                    .content("content .... " + i)
                    .build();
            boardRepository.save(boardEntity);
        });
    }

    @Test
    @Transactional
    @Commit
    void testUpdate() {
        Optional<BoardEntity> result = boardRepository.findById(2L);
        if(result.isPresent()) {
            BoardEntity boardEntity = result.get();
            boardEntity.changeTitle("update title .... 2");
            boardEntity.changeContent("update content .... 2");
            // C, U
            boardRepository.save(boardEntity);

        }
    }
}