package com.study.board.controller;

import com.study.board.exception.CustomException;
import com.study.board.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/board/apis")
public class BoardApiController {

    @GetMapping("/")
    public String test() {
        throw new CustomException(ErrorCode.POST_NOT_FOUND);
    }
}
