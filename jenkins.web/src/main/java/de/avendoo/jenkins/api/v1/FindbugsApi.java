package de.avendoo.jenkins.api.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.avendoo.jenkins.domain.Findbugs;
import de.avendoo.jenkins.properties.JenkinsProperties;
import de.avendoo.jenkins.rest.FindbugsService;

@Controller
@RequestMapping("/api/v1/findbugs")
public class FindbugsApi extends AbstractApi {

	private FindbugsService findbugsService;

	@RequestMapping(value="/default", method = RequestMethod.GET)
	@ResponseBody
	public Findbugs getDefaultFindbugsResult() {
		setupBuildJobService();
		setupFindbugsService();
				
		return findbugsService.findbugsLastBuild(JenkinsProperties.getInstance().getMetricsJob());
	}
	
	private void setupFindbugsService() {
		findbugsService = getRestAdapter().create(FindbugsService.class);
	}
}
