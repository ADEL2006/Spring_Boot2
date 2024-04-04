package kr.hs.dge.dgsw.ex1.controller;

import kr.hs.dge.dgsw.ex1.dto.BoardDTO;
import kr.hs.dge.dgsw.ex1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/replies")
@RequiredArgsConstructor
public class ReplyController {

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void register() {

    }
    @GetMapping("/board/{bno}")
    public void getList() {

    }
    @PutMapping("/{rno}")
    public void modify() {

    }
    @DeleteMapping("/{rno}")
    public void remove() {

    }
    
}
