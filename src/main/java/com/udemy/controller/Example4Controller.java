package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.model.Person;

@Controller
@RequestMapping("/example4")
public class Example4Controller {
	public static final String PAGE404_VIEW= "404";
	public static final String PAGE500_VIEW= "500";
	
	@GetMapping("/show404")
	public String show404(Model model) {
		//model.addAttribute("person",new Person());
		return PAGE404_VIEW;
	}
	
	@GetMapping("/show500")
	public String show500(Model model) {
		//model.addAttribute("person",new Person());
		return PAGE500_VIEW;
	}

}
