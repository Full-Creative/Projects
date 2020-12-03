import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
import controller.EventControllerImpl;
import model.Event;
import model.ParticipantDetails;

public class ScheduleEvent {
	public static void main(String[] args) {
		EventControllerImpl eventController = new EventControllerImpl();

		eventController.addEvents(4);
		eventController.addParticipants(1, 3);
		eventController.addParticipants(2, 4);
		eventController.addParticipants(3, 1);

		eventController.addParticipants(3, 5);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		System.out.println("The list of events are");
		for (Entry<Integer, Event> entry : eventController.eventDB.getEvents().entrySet()) {
			int participants = (entry.getValue().getParticipants() == null) ? 0
					: entry.getValue().getParticipants().size();
			System.out.print("Event ID = " + entry.getKey() + ", " + " Event Duration "
					+ entry.getValue().getEventDuration() / 3600000 + "hrs" + "  Event Time: "
					+ (sdf.format(new Date(entry.getValue().getEventTime()))) + "  Event Created Time:  "
					+ (sdf.format(new Date(entry.getValue().getEventCreatedTime()))) + " Number of participants: "
					+ participants 
					+" Event name " + entry.getValue().getEventTitle()
					+ "\n");
		}

		// Sorted based on participants count
		System.out.print("\nSort based on participant count");
		for (Entry<Integer, Event> entry : eventController.sortByParticipantCount().entrySet()) {
			System.out.print("\nEvent ID = " + entry.getKey() + ",");
			if (entry.getValue().getParticipants() != null)
				for (ParticipantDetails p : entry.getValue().getParticipants()) {
					System.out.print(p.getEmail() + " ");
				}
		}
		System.out.print("\n\nSort based on Event Duration");
		for (Entry<Integer, Event> entry : eventController.sortByEventDuration().entrySet()) {
			System.out.print("\nEvent ID = " + entry.getKey() + ", Event Duration "
					+ entry.getValue().getEventDuration() / 3600000 + "hrs");
		}
		System.out.print("\n\nSort based on  Event Created Time");
		for (Entry<Integer, Event> entry : eventController.sortByEventCreated().entrySet()) {
			System.out.print("\nEvent ID = " + entry.getKey() + ",Event Created Time "
					+ (sdf.format(new Date(entry.getValue().getEventCreatedTime()))));
		}

		System.out.print("\n\nSort based on  Event Time");
		for (Entry<Integer, Event> entry : eventController.sortByEventTime().entrySet()) {
			System.out.print("\nEvent ID = " + entry.getKey() + ", Created Time  "
					+ (sdf.format(new Date(entry.getValue().getEventTime()))));
		}

		/*String myDate = "2014/10/29 19:10:45";
		sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date;
		long millis = 0;
		try {
			date = sdf.parse(myDate);
			millis = date.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long res = (1414590045000L) - (1414676445000L);
		System.out.println("\n" + res);
		// System.out.println("30/10 "+ "1414676445000");
		// System.out.println(3600000*3);
*/
	}

}
