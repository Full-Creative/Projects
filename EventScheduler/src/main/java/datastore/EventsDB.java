package datastore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import model.Event;
import model.ParticipantDetails;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.SortDirection;

import static com.googlecode.objectify.ObjectifyService.ofy;
import com.google.gson.Gson;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.VoidWork;

//import com.google.cloud.Date;

public class EventsDB {
	private Map<Long, Event> events;
	private DatastoreService datastore;

	public EventsDB() {
		events = new HashMap<Long, Event>();
		datastore = DatastoreServiceFactory.getDatastoreService();

	}

	public Event getEvent(long id) throws EntityNotFoundException {
		Event event = new Event();
		Key eventKey = KeyFactory.createKey("Event", id);
		Entity e = datastore.get(eventKey);
		event = entityToObject(e);
		return event;
	}

	public boolean setEvent(Event event) {
		this.events.put(event.getEventID(), event);
		Key key = KeyFactory.createKey("Event", event.getEventID());

//		Entity eventEntity = datastore.get(KeyFactory.createKey("Event", event.getEventID()));
//		if (eventEntity == null) 

		Entity eventEntity = new Entity(key);

		eventEntity.setProperty("EventID", event.getEventID());
		eventEntity.setProperty("EventTitle", event.getEventTitle());
		eventEntity.setProperty("EventDuration", event.getEventDuration());
		eventEntity.setProperty("EventTime", event.getEventTime());
		eventEntity.setProperty("EventCreatedTime", System.currentTimeMillis());

		// ObjectifyService.ofy().save().entity(event).now();
//		ObjectifyService.init();
//		ObjectifyService.begin();
//		ObjectifyService.register(Event.class);
//		ObjectifyService.register(ParticipantDetails.class);
//		ofy().save().entity(event).now();
		datastore.put(eventEntity);
		return true;
	}

	public boolean updateEvent(Event event) {
		try {
			Entity eventEntity = datastore.get(KeyFactory.createKey("Event", event.getEventID()));
			if (eventEntity != null) {
				if (event.getEventTitle() != null)
					eventEntity.setProperty("EventTitle", event.getEventTitle());
				if (event.getEventDuration() != 0)
					eventEntity.setProperty("EventDuration", event.getEventDuration());
				if (event.getEventTime() != 0)
					eventEntity.setProperty("EventTime", event.getEventTime());
			}

			datastore.put(eventEntity);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean deleteEvent(long id) throws EntityNotFoundException {
		Key eventKey = KeyFactory.createKey("Event", id);
		Entity eventEntity = datastore.get(eventKey);
		if (eventEntity == null)
			throw new IllegalArgumentException("Event not available");
		datastore.delete(eventKey);
		return true;
	}

	public boolean createParticipant(ParticipantDetails participant) {
		Key participantKey = KeyFactory.createKey("Participant", participant.getEmail());
		Entity participantEntity = new Entity(participantKey);

		participantEntity.setProperty("ParticipantName", participant.getName());
		participantEntity.setProperty("ParticipantEmail", participant.getEmail());
		datastore.put(participantEntity);
		return true;
	}

	public boolean addParticipant(ParticipantDetails participant) {

		List<String> emails = new ArrayList<String>();
		try {
			Entity existingParticipantEntity = datastore
					.get(KeyFactory.createKey("Participant", participant.getEmail()));
			Entity eventEntity = datastore.get(KeyFactory.createKey("Event", participant.getEventId()));

			if (eventEntity.getProperty("Email") != null) {
				emails = new Gson().fromJson(eventEntity.getProperty("Email").toString(), List.class);
			}

			if (!emails.contains(participant.getEmail()))
				emails.add(participant.getEmail());
			eventEntity.setProperty("Email", emails);
			datastore.put(eventEntity);

		} catch (EntityNotFoundException e) {
			createParticipant(participant);
			addParticipant(participant);
			e.printStackTrace();
		}
		return true;
	}

	public Event entityToObject(Entity entity) {

		Event event = new Event();
		event.setEventID((long) entity.getProperty("EventID"));
		event.setEventTitle(String.valueOf(entity.getProperty("EventTitle")));
		event.setEventDuration((long) entity.getProperty("EventDuration"));
		event.setEventCreatedTime((long) entity.getProperty("EventCreatedTime"));
		event.setEventTime((long) entity.getProperty("EventTime"));
		return event;
	}

	public List<Entity> sortQueryAsc(String property) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("Event").addSort(property, SortDirection.ASCENDING);
		PreparedQuery pq = datastore.prepare(q);
		return pq.asList(FetchOptions.Builder.withDefaults());
	}

	public List<Event> sortByDuration() {
		List<Event> events = new ArrayList<Event>();
		for (Entity e : sortQueryAsc("EventDuration")) {
			events.add(entityToObject(e));
		}
		return events;
	}

	public List<Event> sortByCreatedTime() {
		List<Event> events = new ArrayList<Event>();
		for (Entity e : sortQueryAsc("EventCreatedTime")) {
			events.add(entityToObject(e));
		}
		return events;
	}

	public List<Event> sortByStartTime() {
		List<Event> events = new ArrayList<Event>();
		for (Entity e : sortQueryAsc("EventTime")) {
			events.add(entityToObject(e));
		}
		return events;
	}

	public List<Event> retrieveByTimeRange(long start, long end) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter greaterThan = new Query.FilterPredicate("EventTime", FilterOperator.GREATER_THAN_OR_EQUAL, start);
		Filter lessThan=new Query.FilterPredicate("EventTime",FilterOperator.LESS_THAN_OR_EQUAL,end);
		Query q = new Query("Event").setFilter(greaterThan).setFilter(lessThan);

//		Query query = new Query("Event");
//		query.addFilter("EventTime", Query.FilterOperator.LESS_THAN_OR_EQUAL, end);
//		query.addFilter("EventTime", Query.FilterOperator.GREATER_THAN_OR_EQUAL, start);
		PreparedQuery pq = datastore.prepare(q);

		List<Event> events = new ArrayList<Event>();
		for (Entity e : pq.asList(FetchOptions.Builder.withDefaults())) {
			events.add(entityToObject(e));
		}
		return events;
	}

	public List<Event> sortByParticipantCount() {

		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("Event").addSort("Email", SortDirection.DESCENDING);
		PreparedQuery pq = datastore.prepare(q);
		List<Event> events = new ArrayList<Event>();
		for (Entity e : pq.asList(FetchOptions.Builder.withDefaults())) {
			events.add(entityToObject(e));
		}
		return events;

	}

	/*
	 * public Map<Long, Event> getEvents() { return events; }
	 * 
	 * public boolean setEvents(List<Event> events) { // this.events = events; for
	 * (int i = 0; i < events.size(); i++) {
	 * this.events.put(events.get(i).getEventID(), events.get(i)); } for (int i = 0;
	 * i < events.size(); i++) { Key key = KeyFactory.createKey("Event",
	 * events.get(i).getEventID()); Entity event = new Entity(key);
	 * event.setProperty("EventID", events.get(i).getEventID());
	 * event.setProperty("EventTitle", events.get(i).getEventTitle());
	 * event.setProperty("EventDuration", events.get(i).getEventDuration());
	 * event.setProperty("EventTime", events.get(i).getEventTime());
	 * event.setProperty("EventCreatedTime", events.get(i).getEventCreatedTime());
	 * datastore.put(event); } return true; }
	 * 
	 * public boolean removeEvents(List<Integer> id) { for (Integer i : id)
	 * this.events.remove(i); return true; }
	 */
}
