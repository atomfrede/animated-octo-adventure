package de.atomfrede.jenkins.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.atomfrede.jenkins.domain.AnalysisResult;
import de.atomfrede.jenkins.properties.JenkinsProperties;
import de.atomfrede.jenkins.rest.AnalysisService;

@Controller
@RequestMapping("/api/v1/analysis")
public class AnalysisApi extends AbstractApi {

	private AnalysisService analysisService;

	@RequestMapping(value = "/default", method = RequestMethod.GET)
	@ResponseBody
	public AnalysisResult getDefaultAnalysisResult() {
		setupBuildJobService();
		setupAnalysisService();

        AnalysisResult lastBuild = analysisService.analysisLastBuild(JenkinsProperties.getInstance().getMetricsJob());
        AnalysisResult referenceBuild = analysisService.analysis(JenkinsProperties.getInstance().getMetricsJob(), lastBuild.getReferenceBuild().getNumber());

        int diffLowPrio = lastBuild.getNumberOfLowPriorityWarnings() - referenceBuild.getNumberOfLowPriorityWarnings();
        int diffNormalPrio = lastBuild.getNumberOfNormalPriorityWarnings() - referenceBuild.getNumberOfNormalPriorityWarnings();
        int diffHighPrio = lastBuild.getNumberOfHighPriorityWarnings() - referenceBuild.getNumberOfHighPriorityWarnings();

        lastBuild.setNumberOfNewLowPriorityWarnings(diffLowPrio);
        lastBuild.setNumberOfNewNormalPriorityWarnings(diffNormalPrio);
        lastBuild.setNumberOfNewHighPriorityWarnings(diffHighPrio);

		return lastBuild;
	}

	private void setupAnalysisService() {
		analysisService = getRestAdapter().create(AnalysisService.class);
	}
}
