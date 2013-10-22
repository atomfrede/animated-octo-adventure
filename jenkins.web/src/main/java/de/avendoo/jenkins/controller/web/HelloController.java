package de.avendoo.jenkins.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public ModelAndView helloWorld() {
		ModelAndView model = new ModelAndView("HelloWorldPage");
		model.addObject("msg", "Hello Jenkins!");
		
		return model;
	}	

}
