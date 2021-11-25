package com.myboard.service;

import com.myboard.dto.BoardDto;
import com.myboard.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper mapper;

    @Override
    public List<BoardDto> viewAll() {
        return mapper.viewAll();
    }

    @Override
    public List<BoardDto> listView() {
        return mapper.listView();
    }

    @Override
    public int insertBoard(BoardDto vo) {
        return mapper.insertBoard(vo);
    }

    @Override
    public BoardDto contentView(int b_no) {
        return mapper.contentView(b_no);
    }

}
