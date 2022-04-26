package com.study.board.service;

import com.study.board.entity.board.Board;

import java.util.List;

public interface BoardService {

    /**
     * Board 저장
     *
     * @param board Board 객체
     *
     * @return {@link Board}
     */
    Board saveBoard(Board board);

    /**
     * Board 리스트 조회
     *
     * @return {@link List<Board>}
     * */
    List<Board> findAll();

    /**
     * Board 상세 조회
     *
     * @param id Board index
     *
     * @return {@link Board}
     * */
    Board findById(Long id);
}
