package de.atomfrede.jenkins.v1;

import java.util.concurrent.TimeUnit;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

import com.squareup.okhttp.OkHttpClient;

import de.atomfrede.jenkins.properties.JenkinsProperties;
import de.atomfrede.jenkins.rest.BuildJobService;

public abstract class AbstractApi {
	
	protected BuildJobService buildJobService;
	
	protected void setupBuildJobService() {
		buildJobService = getRestAdapter().create(BuildJobService.class);
	}
	
	protected RestAdapter getRestAdapter() {
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
