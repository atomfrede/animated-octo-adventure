package de.avendoo.jenkins.api.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.avendoo.jenkins.domain.TestReport;
import de.avendoo.jenkins.properties.JenkinsProperties;
import de.avendoo.jenkins.rest.TestReportService;

@Controller
@RequestMapping("/api/v1/testreport")
public class TestReportApi extends AbstractApi {

	private TestReportService testReport;

	@RequestMapping(value = "/default", method = RequestMethod.GET)
	@ResponseBody
	public TestReport getDefaultAnalysisResult() {
		setupBuildJobService();
		setupTestReportService();

		return testReport.testReportLastBuild(JenkinsProperties.getInstance().getMetricsJob());
	}

	private void setupTestReportService() {
		testReport = getRestAdapter().create(TestReportService.class);
	}
}
