//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//
//import org.junit.Test;
//
//import controller.EventServiceImp;
//import generator.DataGenerator;
//import model.Event;
//
//public class AddEventTest {
//
//	@Test
//	public void AddEvents1() {
//		Map<Integer,Event> testEvents=new HashMap<Integer,Event>();
//		List<Event> events=new ArrayList<Event>();
//		long hour = 0;
//		for (int i = 1; i <= 3; i++) {
//			Event eventDetails = new Event();
//			eventDetails.setEventTitle("Event" + i);
//			eventDetails.setEventCreatedTime(System.currentTimeMillis());
//			eventDetails.setEventDuration(3600000 * (3 - i + 1));
//			long millis = 1414590045000L;
//			eventDetails.setEventTime(millis - hour);
//			hour += 86400000;
//			events.add(eventDetails);
//			testEvents.put(i, eventDetails);
//		}
//		Map<Integer,Event> resultEvents=new EventServiceImp().addEvents(events);
//	
//		assertEquals(testEvents,resultEvents);
//		
//	}
//	@Test
//	public void AddEvents2() {
//		Map<Integer,Event> testEvents=new HashMap<Integer,Event>();
//		List<Event> events=new ArrayList<Event>();
//		long hour = 0;
//		for (int i = 1; i <= 3; i++) {
//			Event eventDetails = new Event();
//			eventDetails.setEventTitle("Event" + i);
//			eventDetails.setEventCreatedTime(1414590045000L);
//			eventDetails.setEventDuration(3600000 * (3 - i + 1));
//			long millis = 1414590045000L;
//			eventDetails.setEventTime(millis - hour);
//			hour += 86400000;
//			events.add(eventDetails);
//			testEvents.put(i, eventDetails);
//		}
//		
//		Map<Integer,Event> resultEvents=new EventServiceImp().addEvents(new DataGenerator().generateEvents(3));
//		
//		for (Entry<Integer, Event> entry : testEvents.entrySet()) {
//			int participants = (entry.getValue().getParticipants() == null) ? 0
//					: entry.getValue().getParticipants().size();
//			System.out.print("Event ID = " + entry.getKey() + ", " + " Event Duration "
//					+ entry.getValue().getEventDuration() / 3600000 + "hrs" + "  Event Time: "
//					+ entry.getValue().getEventTime() + "  Event Created Time:  "
//					+ entry.getValue().getEventCreatedTime() + " Number of participants: "
//					+ participants + " Event name " + entry.getValue().getEventTitle() + "\n");
//		}
//		System.out.println("\n\n rsult");
//		for (Entry<Integer, Event> entry : resultEvents.entrySet()) {
//			int participants = (entry.getValue().getParticipants() == null) ? 0
//					: entry.getValue().getParticipants().size();
//			System.out.print("Event ID = " + entry.getKey() + ", " + " Event Duration "
//					+ entry.getValue().getEventDuration() / 3600000 + "hrs" + "  Event Time: "
//					+ entry.getValue().getEventTime() + "  Event Created Time:  "
//					+ entry.getValue().getEventCreatedTime() + " Number of participants: "
//					+ participants + " Event name " + entry.getValue().getEventTitle() + "\n");
//			
//		}
//		System.out.println(resultEvents.get(1).hashCode());
//		System.out.println(testEvents.get(1).hashCode());
//		
//		//assertNotEquals(resultEvents.get(1),testEvents.get(1));
//	//Assertions.assertIterableEquals(resultEvents.get(1), testEvents.get(1));
//	     
//		//assertFalse(resultEvents.equals(testEvents));
//		
//	}
//}
