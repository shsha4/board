package com.study.board.repository.board;

import com.study.board.entity.board.Board;

import java.util.List;

public interface BoardRepositoryCustom {
    List<Board> findByTitle();
}
