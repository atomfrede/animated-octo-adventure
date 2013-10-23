package de.avendoo.jenkins.domain;

import java.io.Serializable;

public class Findbugs implements Serializable {

	private static final long serialVersionUID = -7494649818619999997L;
	
	private int numberOfFixedWarnings;
	private int numberOfHighPriorityWarnings;
	private int numberOfLowPriorityWarnings;
	private int numberOfNewWarnings;
	private int numberOfNormalPriorityWarnings;
	private int numberOfWarnings;
	
	
	public Findbugs setNumberOfFixedWarnings(int numberOfFixedWarnings) {
		this.numberOfFixedWarnings = numberOfFixedWarnings;
		return this;
	}
	
	public Findbugs setNumberOfHighPriorityWarnings(int numberOfHighPriorityWarnings) {
		this.numberOfHighPriorityWarnings = numberOfHighPriorityWarnings;
		return this;
	}
	
	public Findbugs setNumberOfLowPriorityWarnings(int numberOfLowPriorityWarnings) {
		this.numberOfLowPriorityWarnings = numberOfLowPriorityWarnings;
		return this;
	}
	
	public Findbugs setNumberOfNewWarnings(int numberOfNewWarnings) {
		this.numberOfNewWarnings = numberOfNewWarnings;
		return this;
	}
	
	public Findbugs setNumberOfNormalPriorityWarnings(int numberOfNormalPriorityWarnings) {
		this.numberOfNormalPriorityWarnings = numberOfNormalPriorityWarnings;
		return this;
	}
	
	public Findbugs setNumberOfWarnings(int numberOfWarnings) {
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
