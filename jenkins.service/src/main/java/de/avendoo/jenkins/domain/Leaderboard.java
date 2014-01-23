package de.avendoo.jenkins.domain;

import java.util.ArrayList;
import java.util.List;

public class Leaderboard {

	private List<Participant> participants = new ArrayList<Participant>();

	public void addParticipant(Participant participant) {
		this.participants.add(participant);
	}
	
	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}
}
