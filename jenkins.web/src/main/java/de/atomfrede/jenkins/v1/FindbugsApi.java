package de.atomfrede.jenkins.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.atomfrede.jenkins.domain.Findbugs;
import de.atomfrede.jenkins.properties.JenkinsProperties;
import de.atomfrede.jenkins.rest.FindbugsService;

@Controller
@RequestMapping("/api/v1/findbugs")
public class FindbugsApi extends AbstractApi {

	private FindbugsService findbugsService;
    private int numberOfHighPriorityWarnings;

    @RequestMapping(value="/default", method = RequestMethod.GET)
	@ResponseBody
	public Findbugs getDefaultFindbugsResult() {
		setupBuildJobService();
		setupFindbugsService();
				
		Findbugs lastBuild = findbugsService.findbugsLastBuild(JenkinsProperties.getInstance().getMetricsJob());
        Findbugs referenceBuild = findbugsService.findbugs(JenkinsProperties.getInstance().getMetricsJob(), lastBuild.getReferenceBuild().getNumber());


        int diffLowPrio = lastBuild.getNumberOfLowPriorityWarnings() - referenceBuild.getNumberOfLowPriorityWarnings();
	    int diffNormalPrio = lastBuild.getNumberOfNormalPriorityWarnings() - referenceBuild.getNumberOfNormalPriorityWarnings();
        int diffHighPrio = lastBuild.getNumberOfHighPriorityWarnings() - referenceBuild.getNumberOfHighPriorityWarnings();

        lastBuild.setNumberOfNewLowPriorityWarnings(diffLowPrio);
        lastBuild.setNumberOfNewNormalPriorityWarnings(diffNormalPrio);
        lastBuild.setNumberOfNewHighPriorityWarnings(diffHighPrio);

        return lastBuild;
    }
	
	private void setupFindbugsService() {
		findbugsService = getRestAdapter().create(FindbugsService.class);
	}
}
