package de.avendoo.jenkins.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import de.avendoo.jenkins.domain.BuildJob;
import de.avendoo.jenkins.properties.JenkinsProperties;
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
		
		setupBuildJobService();
		BuildJob bj = buildJobService.lastBuildJob(JenkinsProperties.getInstance().getMetricsJob());
		
		model.addObject("buildjob", bj);
		return model;
	}
	
	private void setupBuildJobService() {
		RestAdapter.Builder builder = new RestAdapter.Builder();
		builder.setServer(JenkinsProperties.getInstance().getApiRoot());
		builder.setRequestInterceptor(new RequestInterceptor() {
			
			@Override
			public void intercept(RequestFacade request) {
				request.addHeader("Authorization", "Basic "+JenkinsProperties.getInstance().getAuthHeader());
			}
		});
		
		RestAdapter restAdapter = builder.build();
		buildJobService = restAdapter.create(BuildJobService.class);
	}

}
