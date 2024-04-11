package kr.hs.dge.dgsw.ex1.service;

import kr.hs.dge.dgsw.ex1.dto.ReplyDTO;
import kr.hs.dge.dgsw.ex1.entity.BoardEntity;
import kr.hs.dge.dgsw.ex1.entity.ReplyEntity;
import kr.hs.dge.dgsw.ex1.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface ReplyService {


    default ReplyEntity dtoToEntity(ReplyDTO dto) {
        BoardEntity boardEntity = BoardEntity.builder().bno(dto.getBno()).build();
        return ReplyEntity.builder()
                .rno(dto.getRno())
                .text(dto.getText())
                .replyer(dto.getReplyer())
                .board(boardEntity)
                .build();
    }

    default ReplyDTO entityToDTO (ReplyEntity entity) {
        return ReplyDTO.builder()
                .rno(entity.getRno())
                .text(entity.getText())
                .replyer(entity.getReplyer())
                .createdDate(entity.getCreatedDate())
                .modifiedDate(entity.getModifiedDate())
                .build();

    }

    Long register(ReplyDTO dto);
}
