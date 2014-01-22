package de.avendoo.jenkins.api.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.avendoo.jenkins.domain.Checkstyle;
import de.avendoo.jenkins.properties.JenkinsProperties;
import de.avendoo.jenkins.rest.CheckstyleService;

@Controller
@RequestMapping("/api/v1/checkstyle")
public class CheckstyleApi extends AbstractApi{

	private CheckstyleService checkstyleService;

	@RequestMapping(value="/default", method = RequestMethod.GET)
	@ResponseBody
	public Checkstyle getDefaultFindbugsResult() {
		setupBuildJobService();
		setupCheckstyleService();
				
		return checkstyleService.checkstyleLastBuild(JenkinsProperties.getInstance().getMetricsJob());
	}
	
	private void setupCheckstyleService() {
		checkstyleService = getRestAdapter().create(CheckstyleService.class);
	}
}
