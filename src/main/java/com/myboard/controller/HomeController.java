package com.myboard.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.myboard.dto.BoardDto;
import com.myboard.mapper.BoardMapper;
import com.myboard.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	IBoardService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("list",boardService.listView());
//		model.addAttribute("list",boardListService.list());
//		service = new BoardListService();
//		service.execute(model);
		
		return "/board/list";
	}

	@Autowired
	private BoardServiceImpl boardService;

	@RequestMapping("/temp")
	public String test(Model model){
		model.addAttribute("viewAll",boardService.viewAll());
		return "/board/temp";
	}

	@RequestMapping(value = "/content_view",method = RequestMethod.GET)
	public String Content_view(Model model, @RequestParam(value = "b_no") int seq) {
		
		System.out.println("-----------------Content_view()-----------------" + seq);
		model.addAttribute("content_view",boardService.contentView(seq));
		
		return "/board/content_view";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("-----------------write_view()-----------------");
		return "/board/write_view";
	}
	
	@RequestMapping("/write")
	public String write(BoardDto vo) {
		System.out.println("-----------------write_view()-----------------");
		boardService.insertBoard(vo);
		
		return "redirect:list";
		
	}
	
	
}
