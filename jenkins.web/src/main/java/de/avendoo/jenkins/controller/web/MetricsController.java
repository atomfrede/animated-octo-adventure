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
import de.avendoo.jenkins.view.FindbugsSummaryView;

@Controller
public class MetricsController {
	
	BuildJobService buildJobService;
	TestReportService restReportService;
	FindbugsService findbugsService;
	CheckstyleService checkstyleService;
	DuplicatedCodeService dryService;
	AnalysisService analysisService;
	
	@RequestMapping(value="/metrics", method = RequestMethod.GET)
	public ModelAndView helloWorld() {
		ModelAndView modelAndView = new ModelAndView("MetricsPage");
		
		setupBuildJobService();
		setupFindbugsService();
		setupCheckstyleService();
		setupAnalysisService();
		
		BuildJob bj = buildJobService.lastBuildJob(JenkinsProperties.getInstance().getMetricsJob());
		
		Findbugs fb = null;
		Findbugs oldFb = null;
		Checkstyle cs = null;
		AnalysisResult ar = null;
		AnalysisResult oldAr = null;
		if(bj.isBuilding()) {
			//If the current job is building we don't have analysis results for the current build so use the results from before
			//If this is the first build use empty objects
			if(bj.getNumber() > 1) {
				ar = analysisService.analysis(JenkinsProperties.getInstance().getMetricsJob(), bj.getNumber() - 1);
				fb = findbugsService.findbugs(JenkinsProperties.getInstance().getMetricsJob(), bj.getNumber() - 1);
				cs = checkstyleService.checkstyle(JenkinsProperties.getInstance().getMetricsJob(), bj.getNumber() - 1);
				if(bj.getNumber() > 2) {
					oldAr = analysisService.analysis(JenkinsProperties.getInstance().getMetricsJob(), bj.getNumber() - 2);
					oldFb = findbugsService.findbugs(JenkinsProperties.getInstance().getMetricsJob(), bj.getNumber() - 2);
				} else {
					oldAr = new AnalysisResult();
					oldFb = new Findbugs();
				}
				
			} else {
				ar = new AnalysisResult();
				oldAr = new AnalysisResult();
				fb = new Findbugs();
				oldFb = new Findbugs();
				cs = new Checkstyle();
			}
		} else {
			ar = analysisService.analysisLastBuild(JenkinsProperties.getInstance().getMetricsJob());
			fb = findbugsService.findbugsLastBuild(JenkinsProperties.getInstance().getMetricsJob());
			cs = checkstyleService.checkstyleLastBuild(JenkinsProperties.getInstance().getMetricsJob());
			if(bj.getNumber() > 1) {
				oldAr = analysisService.analysis(JenkinsProperties.getInstance().getMetricsJob(), bj.getNumber() - 1);
				oldFb = findbugsService.findbugs(JenkinsProperties.getInstance().getMetricsJob(), bj.getNumber() - 1);
			} else {
				oldAr = new AnalysisResult();
				oldFb = new Findbugs();
			}
			
			
		}
		
		modelAndView.addObject("analysisSummaryView", new AnalysisResultSummaryView().addAnalysisResult(ar).addLastBuildAnalysisResult(oldAr));
		modelAndView.addObject("checkstyle", cs);
		modelAndView.addObject("findbugsSummaryView", new FindbugsSummaryView().addAnalysisResult(fb).addLastBuildAnalysisResult(oldFb));
		modelAndView.addObject("buildjob", bj);
		return modelAndView;
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
		client.setReadTimeout(5, TimeUnit.MINUTES);
		 
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
