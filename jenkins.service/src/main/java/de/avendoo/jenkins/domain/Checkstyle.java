package de.avendoo.jenkins.domain;

import java.io.Serializable;

import com.google.gson.Gson;

public class Checkstyle extends AnalysisResult implements Serializable {

	private static final long serialVersionUID = -4706718132756777987L;
	
	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
