package de.avendoo.jenkins.rest;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import retrofit.client.Client;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;

public class MockClient implements Client {

	private final Log log = LogFactory.getLog(MockClient.class);
	
	@Override
    public Response execute(Request request) throws IOException {
        URI uri = URI.create(request.getUrl());
		
        log.debug("MOCK SERVER fetching uri: " + uri.toString());

        String responseString = "";

        if(uri.getPath().equals("/path/of/interest")) {
            responseString = "JSON STRING HERE";
        } else {
            responseString = "OTHER JSON RESPONSE STRING";
        }

        return new Response(200, "nothing", Collections.EMPTY_LIST, new TypedByteArray("application/json", responseString.getBytes()));
    }
}
