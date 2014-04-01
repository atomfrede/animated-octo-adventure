package de.atomfrede.jenkins.rest;

import retrofit.http.GET;
import retrofit.http.Path;
import de.atomfrede.jenkins.domain.Findbugs;

public interface FindbugsService {

	@GET("/job/{jobname}/lastBuild/findbugsResult/api/json")
	Findbugs findbugsLastBuild(@Path("jobname") String jobName);
	
	@GET("/job/{jobname}/{buildnumber}/findbugsResult/api/json")
	Findbugs findbugs(@Path("jobname") String jobName, @Path("buildnumber") int buildNumber);
}
