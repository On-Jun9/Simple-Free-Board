package com.myboard.mapper;

import com.myboard.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BoardMapper {
    public List<BoardDto> viewAll();
    public List<BoardDto> listView();
    public int insertBoard(BoardDto vo);
    public BoardDto contentView(int b_no);
}
