package com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.model.Person;
import com.udemy.service.EjercicioService;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {
	
	@Autowired
	@Qualifier("ejercicioService")
	private EjercicioService ejercicioService;

	public static final String EJERCICIO_VIEW = "resultEjercicio";
	
	@GetMapping("/mostrarmensaje")
	public RedirectView redirect() {
		return new RedirectView("/ejercicio/showmessage");
	}
	
	@GetMapping("/showmessage")
	public ModelAndView showForm(Model model) {
		ModelAndView mav =new ModelAndView(EJERCICIO_VIEW);
		mav.addObject("mensaje", ejercicioService.obtenerMensaje());
		return mav;
	}
}
