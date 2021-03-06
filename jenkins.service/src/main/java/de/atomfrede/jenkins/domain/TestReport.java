package de.atomfrede.jenkins.domain;

import java.io.Serializable;

import com.google.gson.Gson;

public class TestReport implements Serializable {

	private static final long serialVersionUID = -974641584792263440L;

	private int failCount;
	private int skipCount;
	private int totalCount;

	public int getFailCount() {
		return failCount;
	}

	public TestReport setFailCount(int failCount) {
		this.failCount = failCount;
		return this;
	}

	public int getSkipCount() {
		return skipCount;
	}

	public TestReport setSkipCount(int skipCount) {
		this.skipCount = skipCount;
		return this;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public TestReport setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		return this;
	}
	
	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

}
