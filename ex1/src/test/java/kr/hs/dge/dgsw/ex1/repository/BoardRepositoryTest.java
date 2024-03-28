package kr.hs.dge.dgsw.ex1.repository;

import jakarta.persistence.Column;
import jakarta.transaction.Transactional;
import kr.hs.dge.dgsw.ex1.entity.BoardEntity;
import kr.hs.dge.dgsw.ex1.entity.MemberEntity;
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
    void testInsert2() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            MemberEntity memberEntity =
                    MemberEntity.builder()
                            .email("user" + i + "@aaa.com")
                            .build();
            BoardEntity boardEntity =
                    BoardEntity.builder()
                            .title("title .... " + i)
                            .content("content .... " + i)
                            .member(memberEntity)
                            .build();
            boardRepository.save(boardEntity);
        });
    }

    @Test
    void testInsert() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
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

    @Test
    @Transactional
    void testRead1() {
        Optional<BoardEntity> result = boardRepository.findById(100L);
        if(result.isPresent()) {
            BoardEntity boardEntity = result.get();
            System.out.println(boardEntity);
            // System.out.println(boardEntity.getMember());
        }
    }
}