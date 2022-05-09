package com.study.board.service;

import com.study.board.dto.PageRequestDTO;
import com.study.board.dto.PageResultDTO;
import com.study.board.entity.board.Board;
import com.study.board.dto.BoardDTO;
import com.study.board.repository.board.BoardRepository;
import com.study.board.exception.CustomException;
import com.study.board.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
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
    public String save(BoardDTO boardDTO) {
        Board board = new Board();
        if (boardDTO.getId() != null) {
            board = boardRepository.findById(boardDTO.getId()).orElse(new Board());
        }
        board = boardDTO.toEntity();
        Board saveBoard = boardRepository.save(board);
        if (saveBoard.getId() != null)  {
            return "Success";
        }
        return "Insert Failed";
    }

    @Override
    public void delete(long id) {
        boardRepository.deleteById(id);
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
    @Override
    public PageResultDTO<BoardDTO, Board> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("id").descending());
        Page<Board> result = boardRepository.findAll(pageable);
        Function<Board, BoardDTO> fn = (Board::toDTO);
        return new PageResultDTO<>(result, fn);
    }
}
