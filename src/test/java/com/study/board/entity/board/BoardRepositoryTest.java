package com.study.board.entity.board;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
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

    /**
     *  Board dummy data insert
     * */
    @Test
    void 더미_데이터_생성() {
        IntStream.range(1, 100).forEach(i -> {
            Board board = Board.builder()
                    .title("Title ... " + i)
                    .content("Content ..." + i)
                    .writer("Writer ..." + i)
                    .build();
            boardRepository.save(board);
        });
    }

    /**
     * QueryDsl 적용 Custom Repository Test
     */
    @Test
    void 조회_테스트() {
        List<Board> list = boardRepository.findByTitle();
        list.forEach(board -> System.out.println(board.getTitle()));
    }
}