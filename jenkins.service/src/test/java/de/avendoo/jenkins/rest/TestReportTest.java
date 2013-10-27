package de.avendoo.jenkins.rest;

import static org.fest.assertions.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import retrofit.RestAdapter;
import de.avendoo.jenkins.domain.TestReport;

public class TestReportTest {

	TestReport tr;
	
	@Before
	public void before() {
		tr = null;
		TestReportService service = getTestReportService();
		tr = service.testReportLastBuild(MockClient.jobName);
	}
	
	@Test
	public void assertNumberOfTestIsCorrect() {
		assertThat(tr.getTotalCount()).isEqualTo(16);
	}
	
	@Test
	public void assertThatFailedCountIsCorrect() {
		assertThat(tr.getFailCount()).isEqualTo(0);
	}
	
	@Test
	public void assertThatSkipCountIsCorrect() {
		assertThat(tr.getSkipCount()).isEqualTo(0);
	}
	
	private TestReportService getTestReportService() {
		RestAdapter.Builder builder = new RestAdapter.Builder();
		builder.setClient(new MockClient());
		builder.setServer(MockClient.server);

		RestAdapter restAdapter = builder.build();
		TestReportService service = restAdapter.create(TestReportService.class);

		return service;
	}
}
