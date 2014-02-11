package de.avendoo.jenkins.api.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.avendoo.jenkins.domain.DuplicatedCode;
import de.avendoo.jenkins.properties.JenkinsProperties;
import de.avendoo.jenkins.rest.DuplicatedCodeService;

@Controller
@RequestMapping("/api/v1/dry")
public class DryApi extends AbstractApi {

	private DuplicatedCodeService dryService;

	@RequestMapping(value="/default", method = RequestMethod.GET)
	@ResponseBody
	public DuplicatedCode getDefaultFindbugsResult() {
		setupBuildJobService();
		setupDryService();

        DuplicatedCode lastBuild = dryService.dryLastBuild(JenkinsProperties.getInstance().getMetricsJob());
        DuplicatedCode referenceBuild = dryService.dry(JenkinsProperties.getInstance().getMetricsJob(), lastBuild.getReferenceBuild().getNumber());

        int diffLowPrio = lastBuild.getNumberOfLowPriorityWarnings() - referenceBuild.getNumberOfLowPriorityWarnings();
        int diffNormalPrio = lastBuild.getNumberOfNormalPriorityWarnings() - referenceBuild.getNumberOfNormalPriorityWarnings();
        int diffHighPrio = lastBuild.getNumberOfHighPriorityWarnings() - referenceBuild.getNumberOfHighPriorityWarnings();

        lastBuild.setNumberOfNewLowPriorityWarnings(diffLowPrio);
        lastBuild.setNumberOfNewNormalPriorityWarnings(diffNormalPrio);
        lastBuild.setNumberOfNewHighPriorityWarnings(diffHighPrio);

        return lastBuild;
	}
	
	private void setupDryService() {
		dryService = getRestAdapter().create(DuplicatedCodeService.class);
	}
}
