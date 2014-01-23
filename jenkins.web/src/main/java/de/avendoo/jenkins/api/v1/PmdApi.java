package de.avendoo.jenkins.api.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.avendoo.jenkins.domain.Pmd;
import de.avendoo.jenkins.properties.JenkinsProperties;
import de.avendoo.jenkins.rest.PmdService;

@Controller
@RequestMapping("/api/v1/pmd")
public class PmdApi extends AbstractApi {
	
	private PmdService pmdService;

	@RequestMapping(value="/default", method = RequestMethod.GET)
	@ResponseBody
	public Pmd getDefaultFindbugsResult() {
		setupBuildJobService();
		setupPmdService();
				
		return pmdService.pmdLastBuild(JenkinsProperties.getInstance().getMetricsJob());
	}
	
	private void setupPmdService() {
		pmdService = getRestAdapter().create(PmdService.class);
	}

}
