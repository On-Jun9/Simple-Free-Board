package com.myboard.service;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.myboard.dao.BoardDao;

public class BoardWriteService implements IBoardService {

	@Override
	public void execute(Model model) {

		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String b_name = request.getParameter("b_name");
		String b_subject = request.getParameter("b_subject");
		String b_content = request.getParameter("b_content");
		Timestamp timenow = new Timestamp(System.currentTimeMillis());
		
		if(b_name != null && b_name !="") {
		
		BoardDao dao = new BoardDao();
		
		dao.write(b_name,b_subject,b_content,timenow);
		
		}

	}

}
