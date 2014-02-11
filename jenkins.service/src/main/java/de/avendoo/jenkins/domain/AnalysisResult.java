package de.avendoo.jenkins.domain;

import java.io.Serializable;

import com.google.gson.Gson;

public class AnalysisResult implements Serializable {

	private static final long serialVersionUID = 1827036930041300688L;
	
	private int numberOfFixedWarnings;
	private int numberOfHighPriorityWarnings;
	private int numberOfLowPriorityWarnings;
	private int numberOfNewWarnings;
	private int numberOfNormalPriorityWarnings;
	private int numberOfWarnings;
    private int numberOfNewHighPriorityWarnings;
    private int numberOfNewNormalPriorityWarnings;
    private int numberOfNewLowPriorityWarnings;

    private ReferenceBuild referenceBuild;
	
	public AnalysisResult setNumberOfFixedWarnings(int numberOfFixedWarnings) {
		this.numberOfFixedWarnings = numberOfFixedWarnings;
		return this;
	}

	public AnalysisResult setNumberOfHighPriorityWarnings(int numberOfHighPriorityWarnings) {
		this.numberOfHighPriorityWarnings = numberOfHighPriorityWarnings;
		return this;
	}

	public AnalysisResult setNumberOfLowPriorityWarnings(int numberOfLowPriorityWarnings) {
		this.numberOfLowPriorityWarnings = numberOfLowPriorityWarnings;
		return this;
	}

	public AnalysisResult setNumberOfNewWarnings(int numberOfNewWarnings) {
		this.numberOfNewWarnings = numberOfNewWarnings;
		return this;
	}

	public AnalysisResult setNumberOfNormalPriorityWarnings(int numberOfNormalPriorityWarnings) {
		this.numberOfNormalPriorityWarnings = numberOfNormalPriorityWarnings;
		return this;
	}

	public AnalysisResult setNumberOfWarnings(int numberOfWarnings) {
		this.numberOfWarnings = numberOfWarnings;
		return this;
	}

    public AnalysisResult setNumberOfNewHighPriorityWarnings(int numberOfNewHighPriorityWarnings) {
        this.numberOfNewHighPriorityWarnings = numberOfNewHighPriorityWarnings;
        return this;
    }

    public AnalysisResult setNumberOfNewNormalPriorityWarnings(int numberOfNewNormalPriorityWarnings) {
        this.numberOfNewNormalPriorityWarnings = numberOfNewNormalPriorityWarnings;
        return this;
    }

    public AnalysisResult setNumberOfNewLowPriorityWarnings(int numberOfNewLowPriorityWarnings) {
        this.numberOfNewLowPriorityWarnings = numberOfNewLowPriorityWarnings;
        return this;
    }

    public AnalysisResult setReferenceBuild(ReferenceBuild referenceBuild) {
        this.referenceBuild = referenceBuild;
        return this;
    }
	
	public int getNumberOfFixedWarnings() {
		return numberOfFixedWarnings;
	}
	
	public int getNumberOfHighPriorityWarnings() {
		return numberOfHighPriorityWarnings;
	}
	
	public int getNumberOfLowPriorityWarnings() {
		return numberOfLowPriorityWarnings;
	}
	
	public int getNumberOfNewWarnings() {
		return numberOfNewWarnings;
	}
	
	public int getNumberOfNormalPriorityWarnings() {
		return numberOfNormalPriorityWarnings;
	}
	
	public int getNumberOfWarnings() {
		return numberOfWarnings;
	}

    public int getNumberOfNewHighPriorityWarnings() {
        return numberOfNewHighPriorityWarnings;
    }

    public int getNumberOfNewNormalPriorityWarnings() {
        return numberOfNewNormalPriorityWarnings;
    }

    public int getNumberOfNewLowPriorityWarnings() {
        return numberOfNewLowPriorityWarnings;
    }

    public ReferenceBuild getReferenceBuild() {
        return referenceBuild;
    }
	
	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
