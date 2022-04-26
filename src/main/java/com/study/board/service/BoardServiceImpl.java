package com.study.board.service;

import com.study.board.entity.board.Board;
import com.study.board.entity.board.BoardDTO;
import com.study.board.entity.board.BoardRepository;
import com.study.board.exception.CustomException;
import com.study.board.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<BoardDTO> findAll() {
        List<Board> boardList = boardRepository.findAll();
        return  boardList.stream().map(Board::toDTO).collect(Collectors.toList());
    }

    @Override
    public BoardDTO findById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));
        return board.toDTO();
    }
}
