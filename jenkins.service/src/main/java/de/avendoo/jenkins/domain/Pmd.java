package de.avendoo.jenkins.domain;

import java.io.Serializable;

import com.google.gson.Gson;

public class Pmd extends AnalysisResult implements Serializable {

	private static final long serialVersionUID = -5229309112741967728L;

	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
