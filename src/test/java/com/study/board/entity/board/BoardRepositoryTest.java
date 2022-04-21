package com.study.board.entity.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Test
    @Transactional
    void 게시글_생성() {
        Board board = Board.builder()
                .title("제목")
                .content("내용")
                .writer("작성자")
                .build();
        boardRepository.save(board);
        Board entity = boardRepository.findById(1L).get();

        assertThat(entity.getContent()).isEqualTo("내용");
    }
}