package com.myboard.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.myboard.dao.BoardDao;
import com.myboard.dto.BoardDto;

public class BoardContentService implements IBoardService {

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String b_no = request.getParameter("b_no");
		
		BoardDao dao= new BoardDao();
		BoardDto dto = dao.contentView(b_no);
		
		model.addAttribute("content_view",dto);

	}

}
