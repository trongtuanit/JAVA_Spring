package com.hithaui;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //đánh dấu xử lý controller
public class AppController {
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	@GetMapping(value = {"/", "/home"}) //trong spring boot mới có cái này :v
//	public String home() {
//		return "index"; //trả về tên file
//	}
	
//	@GetMapping({"/Home"})
//	public ModelAndView home() {
//		ModelAndView mav = new ModelAndView("index");
//		String str = "Nguyễn Đình Huân";
//		mav.addObject("name", str);
//		return mav;
//	}
	
	@GetMapping({"/Home"})
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("index");
		List<String> list = new ArrayList<>();
		list.add("Nguyễn Đình Huân 1");
		list.add("Nguyễn Đình Huân 2");
		list.add("Nguyễn Đình Huân 3");
		list.add("Nguyễn Đình Huân 4");
		
		mav.addObject("listName", list);
		return mav;
	}
	
	
	
	
	
	@GetMapping({"/", "/login"}) //trong spring boot mới có cái này :v
	public String login() {
		return "login"; //trả về tên file
	}
}
