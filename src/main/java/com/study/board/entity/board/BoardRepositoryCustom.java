package com.study.board.entity.board;

import java.util.List;

public interface BoardRepositoryCustom {
    List<Board> findByTitle();
}
