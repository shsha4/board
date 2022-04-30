package com.study.board.service;

import com.study.board.dto.PageRequestDTO;
import com.study.board.dto.PageResultDTO;
import com.study.board.entity.board.Board;
import com.study.board.dto.BoardDTO;

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
    String save(BoardDTO boardDTO);
    /**
     * Board 삭제
     * */
    void delete(long id);

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

    /**
     *  Board 조회 페이징 처리
     *
     * @param requestDTO - PageRequestDTO 객체
     *
     * @return {@link PageResultDTO}
     * */
    PageResultDTO<BoardDTO, Board> getList(PageRequestDTO requestDTO);
}
