package de.avendoo.jenkins.rest;

import retrofit.http.GET;
import retrofit.http.Path;
import de.avendoo.jenkins.domain.Findbugs;

public interface FindbugsService {

	@GET("/job/{jobname}/lastBuild/findbugsResult/api/json")
	Findbugs findbugsResultLastBuild(@Path("jobname") String jobName);
}
