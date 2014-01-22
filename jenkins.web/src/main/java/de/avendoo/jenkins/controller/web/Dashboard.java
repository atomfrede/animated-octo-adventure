package de.avendoo.jenkins.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Dashboard {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView dashboard() {
		return new ModelAndView("Dashboard");
	}
}
