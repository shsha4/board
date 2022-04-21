package com.study.board.entity.reply;

import com.study.board.entity.board.Board;
import com.study.board.entity.board.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ReplyRepositoryTest {
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    ReplyRepository replyRepository;

    @Test
    void insert_test() {
        Board board = boardRepository.findById(1L).get();

        Reply reply = Reply.builder()
                .board(board)
                .content("리플2")
                .writer("리플러2")
                .build();

        replyRepository.save(reply);

    }

    @Test
    void select_test() {
        Board entity = boardRepository.findById(1L).get();
        List<Reply> replyList = entity.getReplyList();

        log.info("{}", replyList);
    }
}