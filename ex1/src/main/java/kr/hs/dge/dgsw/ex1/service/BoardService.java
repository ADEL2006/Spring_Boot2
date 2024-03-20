package kr.hs.dge.dgsw.ex1.service;

import kr.hs.dge.dgsw.ex1.dto.BoardDTO;
import kr.hs.dge.dgsw.ex1.dto.PageRequestDTO;
import kr.hs.dge.dgsw.ex1.dto.PageResultDTO;
import kr.hs.dge.dgsw.ex1.entity.BoardEntity;

public interface BoardService {

    PageResultDTO<BoardDTO, BoardEntity> getList(PageRequestDTO dto);

    Long register(BoardDTO dto);

    BoardDTO get(Long bno);

    void modify(BoardDTO dto);

    void remove(Long bno);

    default BoardDTO entityToDTO(BoardEntity entity) {
        return BoardDTO.builder()
                .bno(entity.getBno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .createDate(entity.getCreatedDate())
                .modifiedDate(entity.getModifiedDate())
                .build();
    }

    default BoardEntity dtoToEntity(BoardDTO dto){
        return BoardEntity.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }
}
