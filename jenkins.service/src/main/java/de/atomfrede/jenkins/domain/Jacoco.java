package de.atomfrede.jenkins.domain;

import java.io.Serializable;

import de.atomfrede.jenkins.domain.coverage.BranchCoverage;
import de.atomfrede.jenkins.domain.coverage.ClassCoverage;
import de.atomfrede.jenkins.domain.coverage.ComplexityScore;
import de.atomfrede.jenkins.domain.coverage.InstructionCoverage;
import de.atomfrede.jenkins.domain.coverage.LineCoverage;
import de.atomfrede.jenkins.domain.coverage.MethodCoverage;

public class Jacoco implements Serializable {

	private static final long serialVersionUID = 5611657462797775119L;
	
	private BranchCoverage branchCoverage;
	private ClassCoverage classCoverage;
	private ComplexityScore complexityScore;
	private InstructionCoverage instructionCoverage;
	private LineCoverage lineCoverage;
	private MethodCoverage methodCoverage;

	public BranchCoverage getBranchCoverage() {
		return branchCoverage;
	}

	public void setBranchCoverage(BranchCoverage branchCoverage) {
		this.branchCoverage = branchCoverage;
	}

	public ClassCoverage getClassCoverage() {
		return classCoverage;
	}

	public void setClassCoverage(ClassCoverage classCoverage) {
		this.classCoverage = classCoverage;
	}

	public ComplexityScore getComplexityScore() {
		return complexityScore;
	}

	public void setComplexityScore(ComplexityScore complexityScore) {
		this.complexityScore = complexityScore;
	}

	public InstructionCoverage getInstructionCoverage() {
		return instructionCoverage;
	}

	public void setInstructionCoverage(InstructionCoverage instructionCoverage) {
		this.instructionCoverage = instructionCoverage;
	}

	public LineCoverage getLineCoverage() {
		return lineCoverage;
	}

	public void setLineCoverage(LineCoverage lineCoverage) {
		this.lineCoverage = lineCoverage;
	}

	public MethodCoverage getMethodCoverage() {
		return methodCoverage;
	}

	public void setMethodCoverage(MethodCoverage methodCoverage) {
		this.methodCoverage = methodCoverage;
	}

}
