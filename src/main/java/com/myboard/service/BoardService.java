package com.myboard.service;

import com.myboard.dto.BoardDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BoardService {
    public List<BoardDto> viewAll();
    public List<BoardDto> listView();
    public int insertBoard(BoardDto vo);
    public BoardDto contentView(int b_no);
}
