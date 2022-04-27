package com.study.board.entity.board;

import com.study.board.dto.BoardDTO;
import com.study.board.entity.BaseEntity;
import com.study.board.entity.reply.Reply;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String writer;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Reply> replyList;

    public BoardDTO toDTO() {
        return BoardDTO.builder().
                id(id).
                title(title).
                content(content).
                writer(writer).
                modDate(getModDate()).
                regDate(getRegDate()).
                replyList(replyList.stream().map(Reply::toDTO).collect(Collectors.toList())).
                build();
    }
}
