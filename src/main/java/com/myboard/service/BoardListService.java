package com.myboard.service;

import java.util.ArrayList;
import java.util.List;

import com.myboard.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.myboard.dao.BoardDao;
import com.myboard.dto.BoardDto;

@Service
public class BoardListService implements IBoardService {
//	@Autowired
//	private BoardMapper mapper;
//
//	@Override
//	public List<BoardDto> list() {
//		return mapper.list();
//	}

	@Override
	public void execute(Model model) {

		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> dtos = dao.list();
		model.addAttribute("list",dtos);

	}

}
