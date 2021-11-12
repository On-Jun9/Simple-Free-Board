package com.myboard.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.myboard.dao.BoardDao;
import com.myboard.dto.BoardDto;

public class BoardListService implements IBoardService {

	@Override
	public void execute(Model model) {

		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> dtos = dao.list();
		model.addAttribute("list",dtos);

	}

}
