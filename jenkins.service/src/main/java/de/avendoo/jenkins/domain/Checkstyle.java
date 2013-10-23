package de.avendoo.jenkins.domain;

import java.io.Serializable;

public class Checkstyle implements Serializable {

	private static final long serialVersionUID = -4706718132756777987L;
	
	private int numberOfFixedWarnings;
	private int numberOfHighPriorityWarnings;
	private int numberOfLowPriorityWarnings;
	private int numberOfNewWarnings;
	private int numberOfNormalPriorityWarnings;
	private int numberOfWarnings;
	
	
	public Checkstyle setNumberOfFixedWarnings(int numberOfFixedWarnings) {
		this.numberOfFixedWarnings = numberOfFixedWarnings;
		return this;
	}

	public Checkstyle setNumberOfHighPriorityWarnings(int numberOfHighPriorityWarnings) {
		this.numberOfHighPriorityWarnings = numberOfHighPriorityWarnings;
		return this;
	}

	public Checkstyle setNumberOfLowPriorityWarnings(int numberOfLowPriorityWarnings) {
		this.numberOfLowPriorityWarnings = numberOfLowPriorityWarnings;
		return this;
	}

	public Checkstyle setNumberOfNewWarnings(int numberOfNewWarnings) {
		this.numberOfNewWarnings = numberOfNewWarnings;
		return this;
	}

	public Checkstyle setNumberOfNormalPriorityWarnings(int numberOfNormalPriorityWarnings) {
		this.numberOfNormalPriorityWarnings = numberOfNormalPriorityWarnings;
		return this;
	}

	public Checkstyle setNumberOfWarnings(int numberOfWarnings) {
		this.numberOfWarnings = numberOfWarnings;
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
}
