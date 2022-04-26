package com.study.board.service;

import com.study.board.entity.board.Board;
import com.study.board.entity.board.BoardRepository;
import com.study.board.exception.CustomException;
import com.study.board.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;

    @Override
    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }
    @Override
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Override
    public Board findById(Long id) {
        return boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));
    }
}
