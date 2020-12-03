package controller;

import java.util.Map.Entry;

import data.EventsDB;
import generator.DataGenerator;
import generator.SortHelper;
import model.Event;
import model.ParticipantDetails;
import java.util.*;

public class EventControllerImpl implements EventController {
	public EventsDB eventDB;

	public EventControllerImpl() {
		eventDB = new EventsDB();
	}

	@Override
	public void addEvents(int numEvents) {
		List<Event> eventDetails = new DataGenerator().generateEvents(numEvents);
		Map<Integer, Event> events = eventDB.getEvents();
		for (int i = 0; i < numEvents; i++) {
			events.put(events.size() + 1, eventDetails.get(i));
			eventDB.setEvents(events);
		}
	}

	@Override
	public void modifyEvent(int id) {
		Map<Integer, Event> events = eventDB.getEvents();
		events.replace(id, new DataGenerator().updateEvent(events.get(id)));
		eventDB.setEvents(events);
	}

	@Override
	public void deleteEvent(int id) {
		Map<Integer, Event> events = eventDB.getEvents();
		events.remove(id);
		eventDB.setEvents(events);
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

	@Override
	public void addParticipants(int id, int number) {
		Map<Integer, Event> events = eventDB.getEvents();
		Set<ParticipantDetails> exisitingParticipants = events.get(id).getParticipants();
		int existing = exisitingParticipants == null ? 0 : exisitingParticipants.size();
		Set<ParticipantDetails> participants = new DataGenerator().generateParticipants(existing, number);
		if (exisitingParticipants != null)
			participants.addAll(exisitingParticipants);

		events.get(id).setParticipants(participants);
		eventDB.setEvents(events);
	}

	public HashMap<Integer, Event> sortByParticipantCount() {
		Map<Integer, Event> events = eventDB.getEvents();
		HashMap<Integer, Event> sortedEvents = new SortHelper().sortByParticipantCountHelper(events);
		return sortedEvents;
	}

	public HashMap<Integer, Event> sortByEventDuration() {
		Map<Integer, Event> events = eventDB.getEvents();
		HashMap<Integer, Event> sortedEvents = new SortHelper().sortByEventDurationHelper(events);
		return sortedEvents;
	}

	public HashMap<Integer, Event> sortByEventCreated() {
		Map<Integer, Event> events = eventDB.getEvents();
		HashMap<Integer, Event> sortedEvents = new SortHelper().sortByEventCreatedHelper(events);
		return sortedEvents;
	}

	public HashMap<Integer, Event> sortByEventTime() {
		Map<Integer, Event> events = eventDB.getEvents();
		HashMap<Integer, Event> sortedEvents = new SortHelper().sortByEventTimeHelper(events);
		return sortedEvents;
	}
}
