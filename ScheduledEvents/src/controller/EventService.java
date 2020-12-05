package controller;

import java.util.*;

import model.Event;
import model.ParticipantDetails;

public interface EventService {
	public Map<Integer,Event> addEvents(List<Event> eventDetails);

	public void addParticipants(int id,Set<ParticipantDetails> participants);

	public Event modifyEvent(int id);

	public void deleteEvent(int id);

	public Event retrieveById(int id);

	public Map<Integer, Event> retrieveByTimeRange(long start, long end);
}
