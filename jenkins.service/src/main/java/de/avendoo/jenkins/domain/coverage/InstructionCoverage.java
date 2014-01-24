package de.avendoo.jenkins.domain.coverage;

import java.io.Serializable;

public class InstructionCoverage implements Serializable  {

	private static final long serialVersionUID = -3988296446944828236L;
	
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
