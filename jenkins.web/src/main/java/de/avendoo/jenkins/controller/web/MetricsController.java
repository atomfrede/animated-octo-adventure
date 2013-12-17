package de.avendoo.jenkins.controller.web;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

import com.squareup.okhttp.OkHttpClient;

import de.avendoo.jenkins.domain.AnalysisResult;
import de.avendoo.jenkins.domain.BuildJob;
import de.avendoo.jenkins.domain.Checkstyle;
import de.avendoo.jenkins.domain.Findbugs;
import de.avendoo.jenkins.properties.JenkinsProperties;
import de.avendoo.jenkins.rest.AnalysisService;
import de.avendoo.jenkins.rest.BuildJobService;
import de.avendoo.jenkins.rest.CheckstyleService;
import de.avendoo.jenkins.rest.DuplicatedCodeService;
import de.avendoo.jenkins.rest.FindbugsService;
import de.avendoo.jenkins.rest.TestReportService;
import de.avendoo.jenkins.view.AnalysisResultSummaryView;
import de.avendoo.jenkins.view.CheckstyleResultSummaryView;
import de.avendoo.jenkins.view.FindbugsSummaryView;
import de.avendoo.jenkins.view.MetricsBuild;

@Controller
public class MetricsController {
	
	private BuildJobService buildJobService;
	private TestReportService testReportService;
	private FindbugsService findbugsService;
	private CheckstyleService checkstyleService;
	private DuplicatedCodeService dryService;
	private AnalysisService analysisService;
	
	private AnalysisResult currentAnalysisResult;
	private Findbugs currentFindbugsResult;
	private Checkstyle currentCheckstyleResult;
	
	private AnalysisResult lastAnalysisResult;
	private Findbugs lastFindbugsResult;
	private Checkstyle lastCheckstyleResult;
	
	@RequestMapping(value="/metrics", method = RequestMethod.GET)
	public ModelAndView defaultMetricsPage() {
		ModelAndView modelAndView = new ModelAndView("MetricsPage");
		
		setupServices();
		
		BuildJob bj = buildJobService.lastBuildJob(JenkinsProperties.getInstance().getMetricsJob());
		
		MetricsBuild metricsBuild = getMetricsBuildResult(bj);
		
		modelAndView.addObject("analysisSummaryView", new AnalysisResultSummaryView().addAnalysisResult(metricsBuild.getCurrentAnalysisResult()).addLastBuildAnalysisResult(metricsBuild.getLastAnalysisResult()));
		modelAndView.addObject("checkstyleSummaryView", new CheckstyleResultSummaryView().addAnalysisResult(metricsBuild.getCurrentCheckstyleResult()).addLastBuildAnalysisResult(metricsBuild.getLastCheckstyleResult()));
		modelAndView.addObject("findbugsSummaryView", new FindbugsSummaryView().addAnalysisResult(metricsBuild.getCurrentFindbugsResult()).addLastBuildAnalysisResult(metricsBuild.getLastFindbugsResult()));
		modelAndView.addObject("buildjob", bj);
		return modelAndView;
	}
	
	private void setupServices() {
		setupBuildJobService();
		setupFindbugsService();
		setupCheckstyleService();
		setupAnalysisService();
	}
	
	private MetricsBuild getMetricsBuildResult(final BuildJob job) {
		MetricsBuild metricsBuild = new MetricsBuild();
		metricsBuild.initWithEmptyResults();
		
		if(job.isBuilding()) {
			getMetricsResultForRunningBuildJob(job);
			return getResultForRunningBuildJob(job);
		} else {
			getMetricsResultsForFinishedBuildJob(job);
			return getResultForFinishedBuildJob(job);
		}
	}
	
	private void getFindbugsResultForRunningBuildJob(final BuildJob job) {
		currentFindbugsResult = new Findbugs();
		lastFindbugsResult = new Findbugs();
		
		if(job.getNumber() > 1) {
			currentFindbugsResult = getFindbugs(job.getNumber() - 1);
		}
		
		if(job.getNumber() > 2) {
			lastFindbugsResult = getFindbugs(job.getNumber() - 2);
		}
	}
	
	private void getCheckstyleResultForRunnungBuildJob(final BuildJob job) {
		currentCheckstyleResult = new Checkstyle();
		lastCheckstyleResult = new Checkstyle();
		
		if(job.getNumber() > 1) {
			currentCheckstyleResult = getCheckstyle(job.getNumber() - 1);
		}
		
		if(job.getNumber() > 2) {
			lastCheckstyleResult = getCheckstyle(job.getNumber() - 2);
		}
	}
	
	private void getAnalysisResultForRunningBuildJob(final BuildJob job) {
		currentAnalysisResult = new AnalysisResult();
		lastAnalysisResult = new AnalysisResult();
		
		if(job.getNumber() > 1) {
			currentAnalysisResult = getAnalysisResult(job.getNumber() - 1);
		}
		
		if(job.getNumber() > 2) {
			lastAnalysisResult = getAnalysisResult(job.getNumber() - 2);
		}
	}
	
	private void getMetricsResultForRunningBuildJob(final BuildJob job) {
		getFindbugsResultForRunningBuildJob(job);
		getCheckstyleResultForRunnungBuildJob(job);
		getAnalysisResultForRunningBuildJob(job);
	}
	
	private MetricsBuild getResultForRunningBuildJob(final BuildJob job) {
		MetricsBuild metricsBuild = new MetricsBuild();
		metricsBuild.initWithEmptyResults();
		
		metricsBuild.setCurrentAnalysisResult(currentAnalysisResult);
		metricsBuild.setCurrentCheckstyleResult(currentCheckstyleResult);
		metricsBuild.setCurrentFindbugsResult(currentFindbugsResult);
		
		metricsBuild.setLastAnalysisResult(lastAnalysisResult);
		metricsBuild.setLastCheckstyleResult(lastCheckstyleResult);
		metricsBuild.setLastFindbugsResult(lastFindbugsResult);
		
		return metricsBuild;
	}
	
	private void getAnalysisResultForFinishedBuildJob(BuildJob job) {
		currentAnalysisResult = analysisService.analysisLastBuild(JenkinsProperties.getInstance().getMetricsJob());
		
		lastAnalysisResult = new AnalysisResult();
		if(job.getNumber() > 1) {
			lastAnalysisResult = getAnalysisResult(job.getNumber() - 1);
		}
	}
	
	private void getFindbugsResultForFinishedBuildJob(BuildJob job) {
		currentFindbugsResult = findbugsService.findbugsLastBuild(JenkinsProperties.getInstance().getMetricsJob());
		
		lastFindbugsResult = new Findbugs();
		if(job.getNumber() > 1) {
			lastFindbugsResult = getFindbugs(job.getNumber() - 1);
		}
	}
	
	private void getCheckstyleResultForFinishedBuildJob(BuildJob job) {
		currentCheckstyleResult = checkstyleService.checkstyleLastBuild(JenkinsProperties.getInstance().getMetricsJob());
		
		lastCheckstyleResult = new Checkstyle();
		if(job.getNumber() > 1) {
			lastCheckstyleResult = getCheckstyle(job.getNumber());
		}
	}
	
	private void getMetricsResultsForFinishedBuildJob(BuildJob job) {
		getAnalysisResultForFinishedBuildJob(job);
		getFindbugsResultForFinishedBuildJob(job);
		getCheckstyleResultForFinishedBuildJob(job);
	}
	
	private MetricsBuild getResultForFinishedBuildJob(final BuildJob job) {
		MetricsBuild metricsBuild = new MetricsBuild();
		metricsBuild.initWithEmptyResults();
		
		metricsBuild.setCurrentAnalysisResult(currentAnalysisResult);
		metricsBuild.setCurrentCheckstyleResult(currentCheckstyleResult);
		metricsBuild.setCurrentFindbugsResult(currentFindbugsResult);
		
		metricsBuild.setLastAnalysisResult(lastAnalysisResult);
		metricsBuild.setLastCheckstyleResult(lastCheckstyleResult);
		metricsBuild.setLastFindbugsResult(lastFindbugsResult);
		
		return metricsBuild;
	}
	
	
	private Findbugs getFindbugs(final int buildNumber) {
		return findbugsService.findbugs(JenkinsProperties.getInstance().getMetricsJob(), buildNumber);
	}
	
	private Checkstyle getCheckstyle(final int buildNumber) {
		return checkstyleService.checkstyle(JenkinsProperties.getInstance().getMetricsJob(), buildNumber);
	}
	
	private AnalysisResult getAnalysisResult(final int buildNumber) {
		return analysisService.analysis(JenkinsProperties.getInstance().getMetricsJob(), buildNumber);
	}
	
	private void setupBuildJobService() {
		buildJobService = getRestAdapter().create(BuildJobService.class);
	}
	
	private void setupFindbugsService() {
		findbugsService = getRestAdapter().create(FindbugsService.class);
	}
	
	private void setupCheckstyleService() {
		checkstyleService = getRestAdapter().create(CheckstyleService.class);
	}
	
	private void setupAnalysisService() {
		analysisService = getRestAdapter().create(AnalysisService.class);
	}
	
	private RestAdapter getRestAdapter() {
		OkHttpClient client = new OkHttpClient();
		client.setReadTimeout(15, TimeUnit.MINUTES);
		 
		RestAdapter.Builder builder = new RestAdapter.Builder();
		builder.setClient(new OkClient(client));
		builder.setServer(JenkinsProperties.getInstance().getApiRoot());
		builder.setRequestInterceptor(new RequestInterceptor() {
			
			@Override
			public void intercept(RequestFacade request) {
				request.addHeader("Authorization", "Basic "+JenkinsProperties.getInstance().getAuthHeader());
			}
		});
		
		RestAdapter restAdapter = builder.build();
		return restAdapter;
	}
	


}
