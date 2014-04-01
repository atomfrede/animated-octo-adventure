package de.atomfrede.jenkins.view;

import de.atomfrede.jenkins.domain.AnalysisResult;

public abstract class AbstractSummaryView {

	protected int numberOfHighPriorityWarnings;
	protected int numberOfNormalPriorityWarnings;
	protected int numberOfLowPriorityWarnings;

	protected int lastBuildNumberOfHighPriorityWarnings;
	protected int lastBuildNumberOfNormalPriorityWarnings;
	protected int lastBuildNumberOfLowPriorityWarnings;
	
	public AbstractSummaryView addAnalysisResult(AnalysisResult ar) {
		numberOfHighPriorityWarnings = ar.getNumberOfHighPriorityWarnings();
		numberOfNormalPriorityWarnings = ar.getNumberOfNormalPriorityWarnings();
		numberOfLowPriorityWarnings = ar.getNumberOfLowPriorityWarnings();
		return this;
	}
	
	public AbstractSummaryView addLastBuildAnalysisResult(AnalysisResult ar) {
		lastBuildNumberOfHighPriorityWarnings = ar.getNumberOfHighPriorityWarnings();
		lastBuildNumberOfNormalPriorityWarnings = ar.getNumberOfNormalPriorityWarnings();
		lastBuildNumberOfLowPriorityWarnings = ar.getNumberOfLowPriorityWarnings();
		return this;
	}
	
	public int getNumberOfHighPriorityWarnings() {
		return numberOfHighPriorityWarnings;
	}

	public AbstractSummaryView setNumberOfHighPriorityWarnings(int numberOfHighPriorityWarnings) {
		this.numberOfHighPriorityWarnings = numberOfHighPriorityWarnings;
		return this;
	}

	public int getNumberOfNormalPriorityWarnings() {
		return numberOfNormalPriorityWarnings;
	}

	public AbstractSummaryView setNumberOfNormalPriorityWarnings(
			int numberOfNormalPriorityWarnings) {
		this.numberOfNormalPriorityWarnings = numberOfNormalPriorityWarnings;
		return this;
	}

	public int getNumberOfLowPriorityWarnings() {
		return numberOfLowPriorityWarnings;
	}

	public AbstractSummaryView setNumberOfLowPriorityWarnings(int numberOfLowPriorityWarnings) {
		this.numberOfLowPriorityWarnings = numberOfLowPriorityWarnings;
		return this;
	}

	public int getLastBuildNumberOfHighPriorityWarnings() {
		return lastBuildNumberOfHighPriorityWarnings;
	}

	public AbstractSummaryView setLastBuildNumberOfHighPriorityWarnings(
			int lastBuildNumberOfHighPriorityWarnings) {
		this.lastBuildNumberOfHighPriorityWarnings = lastBuildNumberOfHighPriorityWarnings;
		return this;
	}

	public int getLastBuildNumberOfNormalPriorityWarnings() {
		return lastBuildNumberOfNormalPriorityWarnings;
	}

	public AbstractSummaryView setLastBuildNumberOfNormalPriorityWarnings(
			int lastBuildNumberOfNormalPriorityWarnings) {
		this.lastBuildNumberOfNormalPriorityWarnings = lastBuildNumberOfNormalPriorityWarnings;
		return this;
	}

	public int getLastBuildNumberOfLowPriorityWarnings() {
		return lastBuildNumberOfLowPriorityWarnings;
	}

	public AbstractSummaryView setLastBuildNumberOfLowPriorityWarnings(
			int lastBuildNumberOfLowPriorityWarnings) {
		this.lastBuildNumberOfLowPriorityWarnings = lastBuildNumberOfLowPriorityWarnings;
		return this;
	}
	
	public int getDiffHighPriorityWarnings() {
		return numberOfHighPriorityWarnings - lastBuildNumberOfHighPriorityWarnings;
	}
	
	public int getDiffNormalPriorityWarnings() {
		return numberOfNormalPriorityWarnings - lastBuildNumberOfNormalPriorityWarnings;
	}
	
	public int getDiffLowPriorityWarnings() {
		return numberOfLowPriorityWarnings - lastBuildNumberOfLowPriorityWarnings;
	}
}
