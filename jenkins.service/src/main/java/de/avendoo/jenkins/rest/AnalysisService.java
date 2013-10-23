package de.avendoo.jenkins.rest;

import retrofit.http.GET;
import retrofit.http.Path;
import de.avendoo.jenkins.domain.AnalysisResult;

public interface AnalysisService {

	@GET("/job/{jobname}/lastBuild/analysisResult/api/json")
	AnalysisResult findbugsLastBuild(@Path("jobname") String jobName);
	
	@GET("/job/{jobname}/{buildnumber}/analysisResult/api/json")
	AnalysisResult findbugs(@Path("jobname") String jobName, @Path("buildnumber") int buildNumber);
}