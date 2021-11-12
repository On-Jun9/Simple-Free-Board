package com.myboard.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myboard.service.BoardContentService;
import com.myboard.service.BoardListService;
import com.myboard.service.IBoardService;


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
		
		service = new BoardListService();
		service.execute(model);
		
		return "/board/list";
	}
	
	@RequestMapping("/content_view")
	public String Content_view(HttpServletRequest request,Model model) {
		
		System.out.println("-----------------Content_view()-----------------");
		model.addAttribute("request", request);
		service = new BoardContentService();
		
		service.execute(model);
		
		return "/board/content_view";
	}
	
	
}
