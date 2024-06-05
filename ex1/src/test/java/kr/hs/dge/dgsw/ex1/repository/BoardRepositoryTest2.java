package kr.hs.dge.dgsw.ex1.repository;

import kr.hs.dge.dgsw.ex1.entity.BoardEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
class BoardRepositoryTest2 {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    void testInsert() {
        IntStream.rangeClosed(0, 100).forEach(i -> {
            BoardEntity boardEntity
                    = BoardEntity.builder()
                    .content("content .... " + i)
                    .title("title .... " + i)
                    .build();
            boardRepository.save(boardEntity);
        });
    }

    @Test
    @Transactional
    @Commit
    void testUpdate() {
        Optional<BoardEntity> result = boardRepository.findById(99L);
        if(result.isPresent()){
            BoardEntity boardEntity = result.get();
            boardEntity.changeTitle("update title .... ");
            boardEntity.changeContent("update content .... ");
            boardRepository.save(boardEntity);
        }
    }
}