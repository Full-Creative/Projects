package controller;

import java.util.*;

import model.Event;

public interface EventController {
	public void addEvents(int numEvents);

	public void addParticipants(int id, int number);

	public void modifyEvent(int id);

	public void deleteEvent(int id);

	public Event retrieveById(int id);

	public Map<Integer, Event> retrieveByTimeRange(long start, long end);
}
