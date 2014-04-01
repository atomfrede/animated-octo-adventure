package de.atomfrede.jenkins.domain.coverage;

import java.io.Serializable;

public class LineCoverage implements Serializable  {

	private static final long serialVersionUID = -8911612004875871662L;
	
	private int percentage;
	private float percentageFloat;
	
	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public float getPercentageFloat() {
		return percentageFloat;
	}

	public void setPercentageFloat(float percentageFloat) {
		this.percentageFloat = percentageFloat;
	}
}
