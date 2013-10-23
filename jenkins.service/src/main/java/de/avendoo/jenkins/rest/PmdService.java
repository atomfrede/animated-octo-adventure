package de.avendoo.jenkins.rest;

import retrofit.http.GET;
import retrofit.http.Path;
import de.avendoo.jenkins.domain.Pmd;

public interface PmdService {

	@GET("/job/{jobname}/lastBuild/pmdResult/api/json")
	Pmd pmdLastBuild(@Path("jobname") String jobName);
	
	@GET("/job/{jobname}/{buildnumber}/pmdResult/api/json")
	Pmd findbpmdugs(@Path("jobname") String jobName, @Path("buildnumber") int buildNumber);
}
