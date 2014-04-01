package de.atomfrede.jenkins.rest;

import retrofit.http.GET;
import retrofit.http.Path;
import de.atomfrede.jenkins.domain.Jacoco;

public interface JacocoService {

	@GET("/job/{jobname}/lastBuild/jacoco/api/json")
	Jacoco jacocoLastBuild(@Path("jobname") String jobName);
	
	@GET("/job/{jobname}/{buildnumber}/jacoco/api/json")
	Jacoco jacoco(@Path("jobname") String jobName, @Path("buildnumber") int buildNumber);
}
