package com.study.board.entity.board;

import com.study.board.entity.reply.ReplyDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDTO {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime modDate;
    private LocalDateTime regDate;
    private List<ReplyDTO> replyList;

    public Board toEntity() {
        return Board.builder().
                title(title).
                content(content).
                writer(writer).
                build();
    }
}
