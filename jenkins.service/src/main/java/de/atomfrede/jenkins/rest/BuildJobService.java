package de.atomfrede.jenkins.rest;

import retrofit.http.GET;
import retrofit.http.Path;
import de.atomfrede.jenkins.domain.BuildJob;

public interface BuildJobService {

	@GET("/job/{jobname}/lastBuild/api/json")
	BuildJob lastBuildJob(@Path("jobname") String jobName);
	
	@GET("/job/{jobname}/{buildnumber}/api/json")
	BuildJob buildJob(@Path("jobname") String jobName, @Path("buildnumber") int buildNumber);
}
