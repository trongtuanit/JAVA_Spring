package com.example.tuanmc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AppController {
//	@RequestMapping({"/home"}) 
//	public ModelAndView defaultPage(){
//		ModelAndView mav = new ModelAndView("index");
//		List<String> list = new ArrayList<>();
//		list.add("tuanmc28");
//		return mav;
//	}
	
	@RequestMapping("/") 
	public ModelAndView login( ) {
		ModelAndView mv = new ModelAndView("login");
		return mv; 
	}
	
	@RequestMapping({"/home"}) 
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView();

		List<Dog> listDog = new ArrayList<>();
		Dog d = new Dog();
		d.setDog("Serjeant", 3, "Husky");
		listDog.add(d);
		Dog e = new Dog();
		e.setDog("Gavaghan", 2, "Golden Retriever");
		listDog.add(e);
		Dog f = new Dog();
		f.setDog("Dedman", 4, "Pitbull");
		listDog.add(f);
		mv.addObject("listDog",listDog);
		
		mv.setViewName("index");
		return mv; 
	}
	
    @RequestMapping(value = { "/gotoData" }, method = RequestMethod.POST)
    public String watchData() {
    	return "redirect:/home";
    }
	
	
	
	
	
	
}
