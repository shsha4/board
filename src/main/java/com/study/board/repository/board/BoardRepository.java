package com.study.board.repository.board;

import com.study.board.entity.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {
    @Query("select b from Board b left join fetch b.replyList")
    List<Board> findAllWithReply();
}
