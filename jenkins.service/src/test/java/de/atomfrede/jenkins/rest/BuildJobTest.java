package de.atomfrede.jenkins.rest;

import org.junit.Before;
import org.junit.Test;

import retrofit.RestAdapter;
import de.atomfrede.jenkins.domain.BuildJob;

import static org.fest.assertions.Assertions.assertThat;

public class BuildJobTest {

	BuildJob bj;

	@Before
	public void before() {
		bj = null;
		BuildJobService service = getBuildJobService();
		bj = service.lastBuildJob(MockClient.jobName);
	}
	
	@Test
	public void assertThatResultIsCorrect() {
		assertThat(bj.getResult()).isEqualTo(BuildJob.Result.SUCCESS);
	}
	
	private BuildJobService getBuildJobService() {
		RestAdapter.Builder builder = new RestAdapter.Builder();
		builder.setClient(new MockClient());
		builder.setServer(MockClient.server);

		RestAdapter restAdapter = builder.build();
		BuildJobService service = restAdapter.create(BuildJobService.class);

		return service;
	}
}
