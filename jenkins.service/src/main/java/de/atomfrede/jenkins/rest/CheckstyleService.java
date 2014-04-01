package de.atomfrede.jenkins.rest;

import retrofit.http.GET;
import retrofit.http.Path;
import de.atomfrede.jenkins.domain.Checkstyle;

public interface CheckstyleService {

	@GET("/job/{jobname}/lastBuild/checkstyleResult/api/json")
	Checkstyle checkstyleLastBuild(@Path("jobname") String jobName);
	
	@GET("/job/{jobname}/{buildnumber}/checkstyleResult/api/json")
	Checkstyle checkstyle(@Path("jobname") String jobName, @Path("buildnumber") int buildNumber);
}
