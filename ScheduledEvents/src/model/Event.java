package model;

import java.util.*;

public class Event {
	// int eventID;
	private String eventTitle;
	private long eventTime;
	private long eventCreatedTime;
	private long eventDuration;
	private Set<ParticipantDetails> participants;

	public long getEventTime() {
		return eventTime;
	}

	public void setEventTime(long eventTime) {
		this.eventTime = eventTime;
	}

	public long getEventCreatedTime() {
		return eventCreatedTime;
	}

	public void setEventCreatedTime(long eventCreatedTime) {
		this.eventCreatedTime = eventCreatedTime;
	}

	public long getEventDuration() {
		return eventDuration;
	}

	public void setEventDuration(long eventDuration) {
		this.eventDuration = eventDuration;
	}

	public Set<ParticipantDetails> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<ParticipantDetails> participants) {
		this.participants = participants;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}



}