package de.atomfrede.jenkins.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.atomfrede.jenkins.domain.TestReport;
import de.atomfrede.jenkins.properties.JenkinsProperties;
import de.atomfrede.jenkins.rest.TestReportService;

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
