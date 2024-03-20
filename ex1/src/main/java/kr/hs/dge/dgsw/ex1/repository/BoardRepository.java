package kr.hs.dge.dgsw.ex1.repository;

import kr.hs.dge.dgsw.ex1.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}
