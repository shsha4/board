package com.study.board.controller;

import com.study.board.dto.PageRequestDTO;
import com.study.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
@Slf4j
public class BoardPageController {

    private final BoardService boardService;

    @GetMapping("/")
    public String index(PageRequestDTO requestDTO, Model model) {
        model.addAttribute("boardList", boardService.getList(requestDTO));
        return "views/main";
    }

    @GetMapping("{id}/detail")
    public String detail(Model model, @PathVariable("id") Long id) {
        model.addAttribute("board", boardService.findById(id));
        return "views/detail";
    }
}
