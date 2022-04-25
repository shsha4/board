package com.study.board.controller;

import com.study.board.entity.board.Board;
import com.study.board.exception.CustomException;
import com.study.board.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/board/apis")
public class BoardApiController {

    @GetMapping("/")
    public String test() {
        throw new CustomException(ErrorCode.POST_NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Board> saveBoard(@RequestBody Board board) {

        log.info("Board: {}", board);
        log.debug("BOARD: {}", board);  // TODO: debug 도 추적 가능하도록 로그레벨 조정

        return ResponseEntity.ok(board);
    }
}
