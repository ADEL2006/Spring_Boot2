package kr.hs.dge.dgsw.ex1.controller;

import kr.hs.dge.dgsw.ex1.dto.BoardDTO;
import kr.hs.dge.dgsw.ex1.dto.PageRequestDTO;
import kr.hs.dge.dgsw.ex1.dto.PageResultDTO;
import kr.hs.dge.dgsw.ex1.entity.BoardEntity;
import kr.hs.dge.dgsw.ex1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody BoardDTO dto) {
        boardService.register(dto);
    }

    // localhost:8080/board/10
    @GetMapping("/{bno}")
    public ResponseEntity<BoardDTO>read(@PathVariable("bno") long bno){
        BoardDTO boardDTO = boardService.get(bno);
        return ResponseEntity.ok(boardDTO);
    }

    // localhost:8080/board/list?page=1&size=10
    // localhost:8080/board/list?page=2&size=20
    @GetMapping("/list")
    public ResponseEntity list(PageRequestDTO requestDTO) {
        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(requestDTO);
        return ResponseEntity.ok(result);
    }
    @PutMapping("")
    public void modify(@RequestBody BoardDTO dto) {
        boardService.modify(dto);
    }

    @DeleteMapping("/{bno}")
    public String delete(@PathVariable("bno") long bno) {
//        boardService.remove(bno);
        boardService.removeWithReplies(bno);
        return "DELETE OK";
    }
}
