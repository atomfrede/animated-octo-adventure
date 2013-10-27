package de.avendoo.jenkins.domain;

import java.io.Serializable;

public class BuildJob implements Serializable {

	private static final long serialVersionUID = 8870787425555539535L;

	// TODO which are the other possible values...
	public enum Result {
		SUCCESS
	}

	private boolean building;
	private long duration;
	private long estimatedDuration;
	private String fullDisplayName;
	private int number;
	private long timestamp;
	private Result result;

	public boolean isBuilding() {
		return building;
	}

	public BuildJob setBuilding(boolean building) {
		this.building = building;
		return this;
	}

	public long getDuration() {
		return duration;
	}

	public BuildJob setDuration(long duration) {
		this.duration = duration;
		return this;
	}

	public long getEstimatedDuration() {
		return estimatedDuration;
	}

	public BuildJob setEstimatedDuration(long estimatedDuration) {
		this.estimatedDuration = estimatedDuration;
		return this;
	}

	public String getFullDisplayName() {
		return fullDisplayName;
	}

	public BuildJob setFullDisplayName(String fullDisplayName) {
		this.fullDisplayName = fullDisplayName;
		return this;
	}

	public int getNumber() {
		return number;
	}

	public BuildJob setNumber(int number) {
		this.number = number;
		return this;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public BuildJob setTimestamp(long timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
}
