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
    void testList() {
        PageRequestDTO requestDTO = new PageRequestDTO();
        PageResultDTO<BoardDTO, BoardEntity> result = boardService.getList(requestDTO);
        result.getDtoList().forEach(dto -> System.out.println(dto));
    }
}