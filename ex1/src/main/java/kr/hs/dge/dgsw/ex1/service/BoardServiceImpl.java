package kr.hs.dge.dgsw.ex1.service;

import jakarta.transaction.Transactional;
import kr.hs.dge.dgsw.ex1.dto.BoardDTO;
import kr.hs.dge.dgsw.ex1.dto.PageRequestDTO;
import kr.hs.dge.dgsw.ex1.dto.PageResultDTO;
import kr.hs.dge.dgsw.ex1.entity.BoardEntity;
import kr.hs.dge.dgsw.ex1.entity.MemberEntity;
import kr.hs.dge.dgsw.ex1.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("bno").descending());
        // Function<BoardEntity, BoardDTO> fn = (entity -> entityToDTO(entity));
        Function<Object[], BoardDTO> fn = objects -> entityToDTO((BoardEntity) objects[0], (MemberEntity) objects[1], (Long)objects[2]);
        // Page<BoardEntity> result = boardRepository.findAll(pageable);
        Page<Object[]> result = boardRepository.getBoardWithReplyCount(pageable);
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public Long register(BoardDTO dto) {
        BoardEntity boardEntity = dtoToEntity(dto);
        boardRepository.save(boardEntity);
        return boardEntity.getBno();
    }

    @Override
    public BoardDTO get(Long bno) {
        // Optional<BoardEntity> result = boardRepository.findById(bno);
        Object result = boardRepository.getBoardByBno(bno);
        Object[] objects = (Object[]) result;
        // SELCT b, m, count(r)
        //      [0][1]  [2]
        return entityToDTO((BoardEntity)objects[0], (MemberEntity)objects[1], (long)objects[2] );
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
