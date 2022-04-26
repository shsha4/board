package com.study.board.service;

import com.study.board.entity.board.Board;
import com.study.board.entity.board.BoardDTO;

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
     * @return {@link List<BoardDTO>}
     * */
    List<BoardDTO> findAll();

    /**
     * Board 상세 조회
     *
     * @param id Board index
     *
     * @return {@link BoardDTO}
     * */
    BoardDTO findById(Long id);
}
