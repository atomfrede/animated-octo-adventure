package de.avendoo.jenkins.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.avendoo.jenkins.notification.NotificationHelper;

@Controller
public class Dashboard {

	@Autowired
	NotificationHelper notification;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView dashboard() {
		return new ModelAndView("Dashboard");
	}
}
