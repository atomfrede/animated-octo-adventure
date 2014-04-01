package de.atomfrede.jenkins.domain.coverage;

import java.io.Serializable;

public class MethodCoverage implements Serializable  {

	private static final long serialVersionUID = 5112237668153896411L;
	
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
