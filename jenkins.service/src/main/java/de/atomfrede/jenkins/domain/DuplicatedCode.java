package de.atomfrede.jenkins.domain;

import java.io.Serializable;

import com.google.gson.Gson;

public class DuplicatedCode extends AnalysisResult implements Serializable {

	private static final long serialVersionUID = -4038578579243827757L;
	
	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

}
