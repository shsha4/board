package com.study.board.service;

import com.study.board.entity.board.Board;

public interface BoardService {

    /**
     * Board 저장
     *
     * @param board Board 객체
     *
     * @return {@link Board}
     */
    Board saveBoard(Board board);

}
