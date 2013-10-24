package de.avendoo.jenkins.rest;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

import de.avendoo.jenkins.domain.Findbugs;
import retrofit.RestAdapter;

public class FindBugsTest {

	@Test
	public void assertThatFindbugsLastBuildReturnsData() {
		FindbugsService service = getFindbugsService();
		Findbugs fb = service.findbugsLastBuild(MockClient.jobName);
		assertThat(fb).isNotNull();
	}

	@Test
	public void assertThatNumberOfFixedWarningsIsCorrect() {
		FindbugsService service = getFindbugsService();
		Findbugs fb = service.findbugsLastBuild(MockClient.jobName);
		assertThat(fb.getNumberOfFixedWarnings()).isEqualTo(0);
	}

	@Test
	public void assertThatNumberOfHighPriorityWarningsIsCorrect() {
		FindbugsService service = getFindbugsService();
		Findbugs fb = service.findbugsLastBuild(MockClient.jobName);
		assertThat(fb.getNumberOfHighPriorityWarnings()).isEqualTo(12);
	}

	@Test
	public void assertThatNumberOfLowPriorityWarningsIsCorrect() {
		FindbugsService service = getFindbugsService();
		Findbugs fb = service.findbugsLastBuild(MockClient.jobName);
		assertThat(fb.getNumberOfLowPriorityWarnings()).isEqualTo(0);
	}

	@Test
	public void assertThatNumberOfNewWarningsIsCorrect() {
		FindbugsService service = getFindbugsService();
		Findbugs fb = service.findbugsLastBuild(MockClient.jobName);
		assertThat(fb.getNumberOfNewWarnings()).isEqualTo(0);
	}

	@Test
	public void assertThatNumberOfNormalPriorityWarningsIsCorrect() {
		FindbugsService service = getFindbugsService();
		Findbugs fb = service.findbugsLastBuild(MockClient.jobName);
		assertThat(fb.getNumberOfNormalPriorityWarnings()).isEqualTo(27);
	}

	@Test
	public void assertThatNumberOfWarningsIsCorrect() {
		FindbugsService service = getFindbugsService();
		Findbugs fb = service.findbugsLastBuild(MockClient.jobName);
		assertThat(fb.getNumberOfWarnings()).isEqualTo(39);
		assertThat(fb.getNumberOfWarnings()).isEqualTo(
				fb.getNumberOfHighPriorityWarnings()
						+ fb.getNumberOfLowPriorityWarnings()
						+ fb.getNumberOfNormalPriorityWarnings());
	}

	private FindbugsService getFindbugsService() {
		RestAdapter.Builder builder = new RestAdapter.Builder();
		builder.setClient(new MockClient());
		builder.setServer(MockClient.server);

		RestAdapter restAdapter = builder.build();
		FindbugsService service = restAdapter.create(FindbugsService.class);

		return service;
	}
}
