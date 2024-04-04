package kr.hs.dge.dgsw.ex1.service;

import kr.hs.dge.dgsw.ex1.dto.BoardDTO;
import kr.hs.dge.dgsw.ex1.dto.PageRequestDTO;
import kr.hs.dge.dgsw.ex1.dto.PageResultDTO;
import kr.hs.dge.dgsw.ex1.entity.BoardEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {
    @Autowired
    private BoardService boardService;

    @Test
    void testRead() {
        Long bno = 1L;
        BoardDTO boardDTO = boardService.get(bno);
        System.out.println(boardDTO);
    }

    @Test
    void testList() {
        PageRequestDTO requestDTO = new PageRequestDTO();
        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(requestDTO);
        result.getDtoList().forEach(dto -> System.out.println(dto));
    }

    @Test
    void testDelete() {
        Long bno = 1L;
        boardService.removeWithReplies(bno);
    }
}