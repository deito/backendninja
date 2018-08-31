package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.model.Person;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	public static final String EXAMPLE_VIEW = "example";

	//Primera forma
	//Para redirecciones, 
	//caundo no hay que insertar datos o muy pocos datos
	@GetMapping("/exampleString")
	//@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	public String exampleString(Model model) {
		model.addAttribute("person", new Person("Jon",23));
		return EXAMPLE_VIEW;
	}
	
	//Segunda Forma
	//Para insertar datos en las plantillas, muchos datos
	//@GetMapping("/exampleMAV")
	@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	public ModelAndView exampleMAV() {
		ModelAndView mav= new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("person", new Person("Mikel",30));
		return mav;
		//return new ModelAndView(EXAMPLE_VIEW);
	}
}
