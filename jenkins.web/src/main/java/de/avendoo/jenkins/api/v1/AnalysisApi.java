package de.avendoo.jenkins.api.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.avendoo.jenkins.domain.AnalysisResult;
import de.avendoo.jenkins.properties.JenkinsProperties;
import de.avendoo.jenkins.rest.AnalysisService;

@Controller
@RequestMapping("/api/v1/analysis")
public class AnalysisApi extends AbstractApi {

	private AnalysisService analysisService;

	@RequestMapping(value = "/default", method = RequestMethod.GET)
	@ResponseBody
	public AnalysisResult getDefaultAnalysisResult() {
		setupBuildJobService();
		setupAnalysisService();

		return analysisService.analysisLastBuild(JenkinsProperties.getInstance().getMetricsJob());
	}

	private void setupAnalysisService() {
		analysisService = getRestAdapter().create(AnalysisService.class);
	}
}
