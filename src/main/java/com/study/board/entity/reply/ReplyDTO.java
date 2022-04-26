package com.study.board.entity.reply;

import com.study.board.entity.board.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyDTO {
    private Long id;
    private String writer;
    private String content;
    private LocalDateTime modDate;
    private LocalDateTime regDate;
    private Long board;

    public Reply toEntity() {
        return Reply.builder().
                writer(writer).
                content(content).
                board(Board.builder().id(board).build()).
                build();
    }
}
