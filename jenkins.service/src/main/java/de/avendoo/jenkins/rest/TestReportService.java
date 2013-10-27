package de.avendoo.jenkins.rest;

import retrofit.http.GET;
import retrofit.http.Path;
import de.avendoo.jenkins.domain.TestReport;

public interface TestReportService {

	@GET("/job/{jobname}/lastBuild/testReport/api/json")
	TestReport testReportLastBuild(@Path("jobname") String jobName);
	
	@GET("/job/{jobname}/{buildnumber}/testReport/api/json")
	TestReport testReport(@Path("jobname") String jobName, @Path("buildnumber") int buildNumber);
}
