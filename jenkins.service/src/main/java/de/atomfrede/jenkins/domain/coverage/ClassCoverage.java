package de.atomfrede.jenkins.domain.coverage;

import java.io.Serializable;

public class ClassCoverage implements Serializable  {

	private static final long serialVersionUID = -8132894251774828498L;
	
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
