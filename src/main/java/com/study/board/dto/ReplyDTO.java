package com.study.board.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.board.entity.board.Board;
import com.study.board.entity.reply.Reply;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime modDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
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
