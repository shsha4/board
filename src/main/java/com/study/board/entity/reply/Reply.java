package com.study.board.entity.reply;

import com.study.board.entity.BaseEntity;
import com.study.board.entity.board.Board;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reply extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String writer;

    @Column
    private String content;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    Board board;

    public ReplyDTO toDTO() {
        return ReplyDTO.builder().
                id(id).
                writer(writer).
                content(content).
                modDate(getModDate()).
                regDate(getRegDate()).
                board(board.getId()).
                build();
    }
}
