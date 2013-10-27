package de.avendoo.jenkins.rest;

import static org.fest.assertions.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import de.avendoo.jenkins.domain.Findbugs;
import retrofit.RestAdapter;

public class FindBugsTest {

	Findbugs fb;
	
	@Before
	public void before() {
		fb = null;
		FindbugsService service = getFindbugsService();
		fb = service.findbugsLastBuild(MockClient.jobName);
	}
	
	@Test
	public void assertThatFindbugsLastBuildReturnsData() {
		assertThat(fb).isNotNull();
	}

	@Test
	public void assertThatNumberOfFixedWarningsIsCorrect() {
		assertThat(fb.getNumberOfFixedWarnings()).isEqualTo(0);
	}

	@Test
	public void assertThatNumberOfHighPriorityWarningsIsCorrect() {
		assertThat(fb.getNumberOfHighPriorityWarnings()).isEqualTo(12);
	}

	@Test
	public void assertThatNumberOfLowPriorityWarningsIsCorrect() {
		assertThat(fb.getNumberOfLowPriorityWarnings()).isEqualTo(0);
	}

	@Test
	public void assertThatNumberOfNewWarningsIsCorrect() {
		assertThat(fb.getNumberOfNewWarnings()).isEqualTo(0);
	}

	@Test
	public void assertThatNumberOfNormalPriorityWarningsIsCorrect() {
		assertThat(fb.getNumberOfNormalPriorityWarnings()).isEqualTo(27);
	}

	@Test
	public void assertThatNumberOfWarningsIsCorrect() {
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
