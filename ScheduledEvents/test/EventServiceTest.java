import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import controller.EventServiceImp;
import datastore.DataBaseException;
import generator.DataGenerator;
import model.Event;

class EventServiceTest {

	@Test
	void testAddEvents() {
		List<Event> events = new ArrayList<Event>();
		long hour = 0;
		for (int i = 1; i <= 3; i++) {

			Event eventDetails = new Event();
			eventDetails.setEventID(i);
			eventDetails.setEventTitle("Event" + i);
			eventDetails.setEventCreatedTime(1414590045000L);
			eventDetails.setEventDuration(3600000 * (3 - i + 1));
			long millis = 1414590045000L;
			eventDetails.setEventTime(millis - hour);
			hour += 86400000;
			events.add(eventDetails);
		}

		List<Event> resultEvents = new EventServiceImp().addEvents(new DataGenerator().generateEvents(3));

		assertEquals(resultEvents, events);

//   assertAll("Test obj1 with obj2 equality",
//		    () -> assertEquals(events.get(i).getEventTitle(), events.get(i).getEventTitle()),
//		    () -> assertEquals(events.get(i).getEventCreatedTime(), resultEvents.get(i).getEventCreatedTime()),
//		    () -> assertEquals(events.get(i).getEventTime(), resultEvents.get(i).getEventTime()));
//   
	}

	@Test
	void testModifyEvent() throws DataBaseException {
		Event resultEvent = new EventServiceImp().modifyEvent(new DataGenerator().generateEvent());
		System.out.print(
				resultEvent.getEventCreatedTime() + " " + resultEvent.getEventID() + " " + resultEvent.getEventTitle()
						+ " " + resultEvent.getEventDuration() + " " + resultEvent.getEventTime());

	}
//
//	@Test
//	void testDeleteEvent() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testAddParticipants() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testRetrieveById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testRetrieveByTimeRange() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSortByParticipantCount() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSortByEventDuration() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSortByEventCreated() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSortByEventTime() {
//		fail("Not yet implemented");
//	}

}
