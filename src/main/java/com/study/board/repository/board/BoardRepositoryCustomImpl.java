package com.study.board.repository.board;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.board.entity.board.Board;
import com.study.board.entity.board.QBoard;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BoardRepositoryCustomImpl implements BoardRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Board> findByTitle() {
        QBoard board = QBoard.board;
        return queryFactory
                .selectFrom(board)
                .where(board.title.contains("1"))
                .fetch();
    }
}
