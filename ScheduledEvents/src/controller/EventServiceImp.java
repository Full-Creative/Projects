package controller;

import java.util.Map.Entry;

import datastore.EventsDB;
import generator.DataGenerator;
import model.Event;
import model.ParticipantDetails;
import java.util.*;

public class EventServiceImp extends SortHelper implements EventService {
	public EventsDB eventDB;

	public EventServiceImp() {
		eventDB = new EventsDB();
	}

	@Override
	public Map<Integer, Event> addEvents(List<Event> eventDetails) {
		if (eventDetails == null || eventDetails.isEmpty())
			throw new IllegalArgumentException("Event Details not available");

		Map<Integer, Event> events = new HashMap<Integer, Event>();
		// Map<Integer, Event> events = eventDB.getEvents();
		for (int i = 0; i < eventDetails.size(); i++) {
			events.put(eventDB.getEvents().size() + 1, eventDetails.get(i));
			eventDB.setEvents(events);
		}

		return eventDB.getEvents();
	}

	@Override
	public Event modifyEvent(int id) {
		Map<Integer, Event> events = eventDB.getEvents();
		if (events.get(id) == null || id<0)
			throw new IllegalArgumentException("Unavailable id");
		events.replace(id, new DataGenerator().updateEvent(events.get(id)));
		eventDB.setEvents(events);
		
		return eventDB.getEvents().get(id);
	}

	@Override
	public void deleteEvent(int id) {
		Map<Integer, Event> events = eventDB.getEvents();
		if (events.get(id) == null)
			throw new IllegalArgumentException("Event Id not available");
		events.remove(id);
		eventDB.setEvents(events);
	}

	@Override
	public void addParticipants(int id, Set<ParticipantDetails> participants) {
		if (participants == null || participants.isEmpty())
			throw new IllegalArgumentException("Participant Details not available");
		if (eventDB.getEvents().get(id) == null || id < 0)
			throw new IllegalArgumentException("No such event");

		eventDB.getEvents().get(id).setParticipants(participants);
//return event.get(id)
	}

	@Override
	public Event retrieveById(int id) {
		Map<Integer, Event> events = eventDB.getEvents();
		return events.get(id);

	}

	@Override
	public Map<Integer, Event> retrieveByTimeRange(long start, long end) {
		Map<Integer, Event> events = eventDB.getEvents();

		Map<Integer, Event> eventsList = new HashMap<Integer, Event>();
		for (Entry<Integer, Event> entry : events.entrySet()) {
			if (entry.getValue().getEventTime() >= start && entry.getValue().getEventTime() <= end)
				eventsList.put(entry.getKey(), entry.getValue());
		}
		return eventsList;
	}

	public HashMap<Integer, Event> sortByParticipantCount() {
		Map<Integer, Event> events = eventDB.getEvents();
		HashMap<Integer, Event> sortedEvents = sortByParticipantCountHelper(events);
		return sortedEvents;
	}

	public HashMap<Integer, Event> sortByEventDuration() {
		Map<Integer, Event> events = eventDB.getEvents();
		HashMap<Integer, Event> sortedEvents = sortByEventDurationHelper(events);
		return sortedEvents;
	}

	public HashMap<Integer, Event> sortByEventCreated() {
		Map<Integer, Event> events = eventDB.getEvents();
		HashMap<Integer, Event> sortedEvents = sortByEventCreatedHelper(events);
		return sortedEvents;
	}

	public HashMap<Integer, Event> sortByEventTime() {
		Map<Integer, Event> events = eventDB.getEvents();
		HashMap<Integer, Event> sortedEvents = sortByEventTimeHelper(events);
		return sortedEvents;
	}
}
