package com.study.board.controller;

import com.study.board.dto.BoardDTO;
import com.study.board.entity.board.Board;
import com.study.board.exception.CustomException;
import com.study.board.exception.ErrorCode;
import com.study.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board/apis")
public class BoardApiController {

    private final BoardService boardService;

//    @PostMapping
//    public ResponseEntity<Board> saveBoard(@RequestBody Board board) {
//
//        log.info("Board: {}", board);
//        log.debug("BOARD: {}", board);  // TODO: debug 도 추적 가능하도록 로그레벨 조정
//
//        return ResponseEntity.ok(board);
//    }

    @PostMapping("/save")
    public ResponseEntity<String> saveBoard(@RequestBody BoardDTO boardDTO) {
        return ResponseEntity.ok(boardService.save(boardDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable("id") long id) {
        boardService.delete(id);
        return ResponseEntity.ok("Success");
    }
}
