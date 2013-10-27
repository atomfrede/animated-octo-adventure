package de.avendoo.jenkins.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.avendoo.jenkins.rest.BuildJobService;
import de.avendoo.jenkins.rest.CheckstyleService;
import de.avendoo.jenkins.rest.DuplicatedCodeService;
import de.avendoo.jenkins.rest.FindbugsService;
import de.avendoo.jenkins.rest.TestReportService;

@Controller
public class HelloController {
	
	BuildJobService buildJobService;
	TestReportService restReportService;
	FindbugsService findbugsService;
	CheckstyleService checkstykeService;
	DuplicatedCodeService dryService;
	
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public ModelAndView helloWorld() {
		ModelAndView model = new ModelAndView("HelloWorldPage");
		model.addObject("msg", "Hello Jenkins!");
		
		return model;
	}	

}
