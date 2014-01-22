package de.avendoo.jenkins.api.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.avendoo.jenkins.domain.BuildJob;
import de.avendoo.jenkins.properties.JenkinsProperties;

@Controller
@RequestMapping("/api/v1/buildjob")
public class BuildJobApi extends AbstractApi {


	@RequestMapping(value = "/default", method = RequestMethod.GET)
	@ResponseBody
	public BuildJob getDefaultAnalysisResult() {
		setupBuildJobService();

		return buildJobService.lastBuildJob(JenkinsProperties.getInstance().getMetricsJob());
	}

}
