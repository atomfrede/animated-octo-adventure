package de.atomfrede.jenkins.domain;

import java.io.Serializable;

import com.google.gson.Gson;

public class Findbugs extends AnalysisResult implements Serializable {

	private static final long serialVersionUID = -7494649818619999997L;	
	
	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
