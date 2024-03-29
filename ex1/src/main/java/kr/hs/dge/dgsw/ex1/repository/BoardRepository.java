package kr.hs.dge.dgsw.ex1.repository;

import kr.hs.dge.dgsw.ex1.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    @Query(value = "SELECT b, m, COUNT(r) " + "FROM BoardEntity b " + "LEFT JOIN b.member m " + "LEFT JOIN ReplyEntity r ON r.board=b " + "GROUP BY b",
            countQuery = "SELECT COUNT(b) FROM BoardEntity b")
    Page<Object[]>getBoardWithReplyCount(Pageable pageable);

    @Query("SELECT b, r " + "FROM BoardEntity b " + "LEFT JOIN ReplyEntity r ON r.board = b " + "WHERE b.bno=:bno")
    List<Optional[]> getBoardWithReply(Long bno);

    @Query("SELECT b, m " + "FROM BoardEntity b " + "LEFT JOIN b.member m " + "WHERE b.bno=:bno") // JPQL
    Object getBoardWithMember(@Param("bno") Long bno);


}
