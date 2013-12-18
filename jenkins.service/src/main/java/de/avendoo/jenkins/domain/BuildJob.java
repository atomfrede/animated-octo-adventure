package de.avendoo.jenkins.domain;

import java.io.Serializable;
import java.util.Locale;

import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import com.google.gson.Gson;

public class BuildJob implements Serializable {

	private static final long serialVersionUID = 8870787425555539535L;

	public enum Result {
		SUCCESS, FAILURE, UNSTABLE
	}

	private boolean building;
	private long duration;
	private String durationText;
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
	
	public String getDurationText() {
		Period period = new Period(getDuration());
		String durationText = new PeriodFormatterBuilder().appendHours().appendMinutes().appendSuffix(" minute", " minutes") .appendSeparator(" and ").appendSeconds() .appendSuffix(" second", " seconds").toFormatter().print(period);
		return durationText;
	}
	
	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
