package de.avendoo.jenkins.rest;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import retrofit.client.Client;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;

public class MockClient implements Client {

	private final Log log = LogFactory.getLog(MockClient.class);
	
	public static final String jobName = "myJob";
	public static final String server = "localhost";
	
	@Override
    public Response execute(Request request) throws IOException {
        URI uri = URI.create(request.getUrl());
		
        log.debug("MOCK SERVER fetching uri: " + uri.toString());

        String responseString = "";
        try {
	        if(uri.getPath().equals(server+"/job/"+jobName+"/lastBuild/findbugsResult/api/json")) {
	        	responseString = FileUtils.readFileToString(new File(this.getClass().getResource("findbugs.json").toURI()));
	        } else if(uri.getPath().equals(server+"/job/"+jobName+"/lastBuild/testReport/api/json")) {
	            responseString = FileUtils.readFileToString(new File(this.getClass().getResource("testreport.json").toURI()));
	        } else if(uri.getPath().equals(server+"/job/"+jobName+"/lastBuild/api/json")) {
	        	responseString = FileUtils.readFileToString(new File(this.getClass().getResource("buildjob.json").toURI()));
	        }
        }catch(URISyntaxException urie){
        	log.error("Could not read result.", urie);
        }

        return new Response(200, "nothing", Collections.EMPTY_LIST, new TypedByteArray("application/json", responseString.getBytes()));
    }
}
