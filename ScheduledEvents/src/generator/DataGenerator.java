package generator;

import java.util.*;

import model.Event;
import model.ParticipantDetails;

public class DataGenerator {

	public List<Event> generateEvents(int numEvents) {
		List<Event> events = new ArrayList<Event>();
		long hour = 0;
		for (int i = 1; i <= numEvents; i++) {
			Event eventDetails = new Event();
			eventDetails.setEventTitle("Event" + i);
			eventDetails.setEventCreatedTime(System.currentTimeMillis());
			eventDetails.setEventDuration(3600000 * (numEvents - i + 1));
			long millis = 1414590045000L;
			eventDetails.setEventTime(millis - hour);
			hour += 86400000;
			events.add(eventDetails);
		}

		return events;
	}

	public Event updateEvent(Event event) {
		event.setEventDuration(129);
		event.setEventTime(System.currentTimeMillis());
		return event;
	}

	public Set<ParticipantDetails> generateParticipants(int existing, int number) {
		Set<ParticipantDetails> participants = new HashSet<ParticipantDetails>();
		for (int j = existing; j < number; j++) {
			ParticipantDetails p = new ParticipantDetails();
			p.setName("name");
			p.setEmail("email" + (j + 1) + "@gmail.com");
			participants.add(p);
		}
		return participants;

	}
}
