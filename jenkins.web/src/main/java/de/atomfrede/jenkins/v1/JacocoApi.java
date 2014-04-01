package de.atomfrede.jenkins.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.atomfrede.jenkins.domain.Jacoco;
import de.atomfrede.jenkins.properties.JenkinsProperties;
import de.atomfrede.jenkins.rest.JacocoService;

@Controller
@RequestMapping("/api/v1/jacoco")
public class JacocoApi extends AbstractApi {

	private JacocoService jacocoService;

	@RequestMapping(value="/default", method = RequestMethod.GET)
	@ResponseBody
	public Jacoco getDefaultFindbugsResult() {
		setupBuildJobService();
		setupJacocoService();
				
		return jacocoService.jacocoLastBuild(JenkinsProperties.getInstance().getMetricsJob());
	}
	
	private void setupJacocoService() {
		jacocoService = getRestAdapter().create(JacocoService.class);
	}
}
