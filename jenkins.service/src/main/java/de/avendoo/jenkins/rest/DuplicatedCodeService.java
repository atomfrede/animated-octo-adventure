package de.avendoo.jenkins.rest;

import retrofit.http.GET;
import retrofit.http.Path;
import de.avendoo.jenkins.domain.DuplicatedCode;
import de.avendoo.jenkins.domain.Findbugs;

public interface DuplicatedCodeService {

	@GET("/job/{jobname}/lastBuild/dryResult/api/json")
	DuplicatedCode findbugsLastBuild(@Path("jobname") String jobName);
	
	@GET("/job/{jobname}/{buildnumber}/dryResult/api/json")
	DuplicatedCode findbugs(@Path("jobname") String jobName, @Path("buildnumber") int buildNumber);
}
