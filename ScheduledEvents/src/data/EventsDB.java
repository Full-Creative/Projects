package data;

import java.util.HashMap;
import java.util.Map;

import model.Event;

public class EventsDB {
	private Map<Integer, Event> events ;

	public EventsDB(){
		events= new HashMap<Integer, Event>();
	}
	public Map<Integer, Event> getEvents() {
		return  events;
	}

	public void setEvents(Map<Integer, Event> events) {
		this.events = events;
	}

}
