package de.atomfrede.jenkins.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.atomfrede.jenkins.domain.Checkstyle;
import de.atomfrede.jenkins.properties.JenkinsProperties;
import de.atomfrede.jenkins.rest.CheckstyleService;

@Controller
@RequestMapping("/api/v1/checkstyle")
public class CheckstyleApi extends AbstractApi{

	private CheckstyleService checkstyleService;

	@RequestMapping(value="/default", method = RequestMethod.GET)
	@ResponseBody
	public Checkstyle getDefaultFindbugsResult() {
		setupBuildJobService();
		setupCheckstyleService();

        Checkstyle lastBuild = checkstyleService.checkstyleLastBuild(JenkinsProperties.getInstance().getMetricsJob());
        Checkstyle referenceBuild = checkstyleService.checkstyle(JenkinsProperties.getInstance().getMetricsJob(), lastBuild.getReferenceBuild().getNumber());

        int diffLowPrio = lastBuild.getNumberOfLowPriorityWarnings() - referenceBuild.getNumberOfLowPriorityWarnings();
        int diffNormalPrio = lastBuild.getNumberOfNormalPriorityWarnings() - referenceBuild.getNumberOfNormalPriorityWarnings();
        int diffHighPrio = lastBuild.getNumberOfHighPriorityWarnings() - referenceBuild.getNumberOfHighPriorityWarnings();

        lastBuild.setNumberOfNewLowPriorityWarnings(diffLowPrio);
        lastBuild.setNumberOfNewNormalPriorityWarnings(diffNormalPrio);
        lastBuild.setNumberOfNewHighPriorityWarnings(diffHighPrio);

        return lastBuild;
	}
	
	private void setupCheckstyleService() {
		checkstyleService = getRestAdapter().create(CheckstyleService.class);
	}
}
