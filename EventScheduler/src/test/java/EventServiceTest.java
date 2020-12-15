import static org.junit.Assert.*;
import org.junit.Test;
import com.google.appengine.api.datastore.EntityNotFoundException;
import model.Event;
import model.ParticipantDetails;
import service.event.EventServiceImp;

public class EventServiceTest {
	public EventServiceImp eventService = new EventServiceImp();

	@Test
	public void testAddEvent() {
		Event eventDetails = new Event();
		eventDetails.setEventTime(0);
		try {
			assertEquals(eventDetails, eventService.addEvent(eventDetails));
		} catch (Exception e) {
			assertEquals("Exception message must be correct", "Event Details not available", e.getMessage());
		}
	}

	@Test
	public void testAddEvent1() {
		Event eventDetails = new Event();
		eventDetails.setEventDuration(0);
		try {
			assertEquals(eventDetails, eventService.addEvent(eventDetails));
		} catch (Exception e) {
			assertEquals("Exception message must be correct", "Event Details not available", e.getMessage());
		}
	}

	@Test
	public void testAddEvent2() {
		Event eventDetails = new Event();
		eventDetails.setEventID(-1);
		try {
			assertEquals(eventDetails, eventService.addEvent(eventDetails));
		} catch (Exception e) {
			assertEquals("Exception message must be correct", "Event Details not available", e.getMessage());
		}
	}

	@Test
	public void testAddEvent3() {
		try {
			assertEquals(null, eventService.addEvent(null));
		} catch (Exception e) {
			assertEquals("Exception message must be correct", "Event Details not available", e.getMessage());
		}
	}

	@Test
	public void testAddEvent4() {
		try {
			assertEquals(null, eventService.addEvent(null));
		} catch (Exception e) {
			assertNotEquals("Exception message must be correct", "Event Details available", e.getMessage());
		}
	}

	@Test
	public void testModifyEvent() {
		Event eventDetails = new Event();
		eventDetails.setEventID(-1);
		try {
			assertEquals(eventDetails, eventService.modifyEvent(eventDetails));
		} catch (Exception e) {
			assertEquals("Exception message must be correct", "Invalid ID", e.getMessage());
		}
	}

	@Test
	public void testRemoveEvent() {
		try {
			eventService.removeEvent(-1);
		} catch (Exception e) {
			assertEquals("Exception message must be correct", "Invalid ID", e.getMessage());
		}
	}

	@Test
	public void testRetrieveById() {
		try {
			assertEquals(new Event(), eventService.retrieveById(-1));
			fail("Should have thrown an exception");
		} catch (Exception e) {
			assertEquals("Exception message must be correct", "Invalid ID", e.getMessage());
		}
	}

	@Test
	public void testAddParticipant() {
		ParticipantDetails participant = new ParticipantDetails();
		participant.setEmail(null);
		try {
			assertEquals(participant, eventService.addParticipant(participant));
		} catch (Exception e) {
			assertEquals("Participant Details not available", e.getMessage());
		}

	}

	@Test
	public void testAddParticipant1() {
		ParticipantDetails participant = new ParticipantDetails();
		participant.setName(null);
		try {
			assertEquals(participant, eventService.addParticipant(participant));
		} catch (Exception e) {
			assertEquals("Participant Details not available", e.getMessage());
		}
	}

	@Test
	public void testAddParticipant2() {
		try {
			assertEquals(null, eventService.addParticipant(null));
		} catch (Exception e) {
			assertEquals("Participant Details not available", e.getMessage());
		}
	}

	@Test
	public void testRetrieveByTimeRange() {
		try {
			assertEquals(null, eventService.retrieveByTimeRange(-1, 0));
		} catch (Exception e) {
			assertEquals("Invalid input", e.getMessage());
		}
	}

	@Test
	public void testRetrieveByTimeRange1() {
		try {
			assertEquals(null, eventService.retrieveByTimeRange(0, -1));
		} catch (Exception e) {
			assertEquals("Invalid input", e.getMessage());
		}
	}

}
