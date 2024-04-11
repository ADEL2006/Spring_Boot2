package kr.hs.dge.dgsw.ex1.service;

import kr.hs.dge.dgsw.ex1.dto.ReplyDTO;
import kr.hs.dge.dgsw.ex1.entity.ReplyEntity;
import kr.hs.dge.dgsw.ex1.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{

    private final ReplyRepository replyRepository;

    @Override
    public Long register(ReplyDTO dto) {
        ReplyEntity replyEntity = dtoToEntity(dto);
        replyRepository.save(replyEntity);
        return replyEntity.getRno();
    }
    
}
