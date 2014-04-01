package de.atomfrede.jenkins.view;

import de.atomfrede.jenkins.domain.AnalysisResult;
import de.atomfrede.jenkins.domain.Checkstyle;
import de.atomfrede.jenkins.domain.DuplicatedCode;
import de.atomfrede.jenkins.domain.Findbugs;

public class MetricsBuild {
	
	private AnalysisResult currentAnalysisResult, lastAnalysisResult;
	
	private Findbugs currentFindbugsResult, lastFindbugsResult;
	
	private Checkstyle currentCheckstyleResult, lastCheckstyleResult;
	
	private DuplicatedCode currentDry, lastDry;
	
	public void initWithEmptyResults() {
		currentAnalysisResult = new AnalysisResult();
		lastAnalysisResult = new AnalysisResult();
		
		currentAnalysisResult = new Findbugs();
		lastFindbugsResult = new Findbugs();
		
		currentCheckstyleResult = new Checkstyle();
		lastCheckstyleResult = new Checkstyle();
		
		currentDry = new DuplicatedCode();
		lastDry = new DuplicatedCode();
	}
	
	public AnalysisResult getCurrentAnalysisResult() {
		return currentAnalysisResult;
	}
	
	public void setCurrentAnalysisResult(AnalysisResult currentAnalysisResult) {
		this.currentAnalysisResult = currentAnalysisResult;
	}
	
	public AnalysisResult getLastAnalysisResult() {
		return lastAnalysisResult;
	}
	
	public void setLastAnalysisResult(AnalysisResult lastAnalysisResult) {
		this.lastAnalysisResult = lastAnalysisResult;
	}
	
	public Findbugs getCurrentFindbugsResult() {
		return currentFindbugsResult;
	}
	
	public void setCurrentFindbugsResult(Findbugs currentFindbugsResult) {
		this.currentFindbugsResult = currentFindbugsResult;
	}
	
	public Findbugs getLastFindbugsResult() {
		return lastFindbugsResult;
	}
	
	public void setLastFindbugsResult(Findbugs lastFindbugsResult) {
		this.lastFindbugsResult = lastFindbugsResult;
	}
	
	public Checkstyle getCurrentCheckstyleResult() {
		return currentCheckstyleResult;
	}
	
	public void setCurrentCheckstyleResult(Checkstyle currentCheckstyleResult) {
		this.currentCheckstyleResult = currentCheckstyleResult;
	}
	
	public Checkstyle getLastCheckstyleResult() {
		return lastCheckstyleResult;
	}
	
	public void setLastCheckstyleResult(Checkstyle lastCheckstyleResult) {
		this.lastCheckstyleResult = lastCheckstyleResult;
	}

	public DuplicatedCode getCurrentDry() {
		return currentDry;
	}

	public void setCurrentDry(DuplicatedCode currentDry) {
		this.currentDry = currentDry;
	}

	public DuplicatedCode getLastDry() {
		return lastDry;
	}

	public void setLastDry(DuplicatedCode lastDry) {
		this.lastDry = lastDry;
	}
}
