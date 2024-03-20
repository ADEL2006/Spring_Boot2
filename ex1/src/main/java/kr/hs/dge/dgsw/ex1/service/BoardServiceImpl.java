package kr.hs.dge.dgsw.ex1.service;

import kr.hs.dge.dgsw.ex1.dto.BoardDTO;
import kr.hs.dge.dgsw.ex1.entity.BoardEntity;
import kr.hs.dge.dgsw.ex1.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    @Override
    public Long register(BoardDTO dto) {
        BoardEntity boardEntity = dtoToEntity(dto);
        boardRepository.save(boardEntity);
        return boardEntity.getBno();
    }

    @Override
    public BoardDTO get(Long bno) {
        Optional<BoardEntity> result =
        boardRepository.findById(bno);
        return (result.isPresent())?entityToDTO(result.get()) : null;
    }

    @Override
    public void modify(BoardDTO dto) {
        Optional<BoardEntity> result =
                boardRepository.findById(dto.getBno());
        if(result.isPresent()) {
            BoardEntity boardEntity = result.get();
            boardEntity.changeTitle(dto.getTitle());
            boardEntity.changeContent(dto.getContent());
            boardRepository.save(boardEntity);
        }
    }

    @Override
    public void remove(Long bno) {
        boardRepository.deleteById(bno);
    }
}
