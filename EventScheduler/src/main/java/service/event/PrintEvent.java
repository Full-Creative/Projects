package service.event;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map.Entry;

import com.google.appengine.api.datastore.EntityNotFoundException;

import service.event.EventServiceImp;
import datastore.EventsDB;
import model.Event;
import model.ParticipantDetails;

public class PrintEvent {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	EventServiceImp eventService;
//	EventsDB eventsDB;

	public PrintEvent(EventServiceImp eventService) {
		this.eventService = eventService;
		// this.eventsDB=new EventsDB();
	}

//	public void listAll() {
//		System.out.println("The list of events are");
//		for (Entry<Long, Event> entry : eventService.eventDB.getEvents().entrySet()) {
//			int participants = (entry.getValue().getParticipantEmail() == null) ? 0
//					: entry.getValue().getParticipantEmail().size();
//			System.out.print("Event ID = " + entry.getValue().getEventID() + ", " + " Event Duration "
//					+ entry.getValue().getEventDuration() / 3600000 + "hrs" + "  Event Time: "
//					+ (sdf.format(new Date(entry.getValue().getEventTime()))) + "  Event Created Time:  "
//					+ (sdf.format(new Date(entry.getValue().getEventCreatedTime()))) + " Number of participants: "
//					+ participants + " Event name " + entry.getValue().getEventTitle() + "\n");
//		}
//	}

	public void displayEvent(int id) throws EntityNotFoundException {
		System.out.println("Event Details : ");
		Event event = eventService.retrieveById(id);
		int participants = (event.getParticipantEmail() == null) ? 0 : event.getParticipantEmail().size();
		System.out.print(
				"Event ID = " + event.getEventID() + ", " + " Event Duration " + event.getEventDuration() / 3600000
						+ "hrs" + "  Event Time: " + (sdf.format(new Date(event.getEventTime())))
						+ "  Event Created Time:  " + (sdf.format(new Date(event.getEventCreatedTime())))
						+ " Number of participants: " + participants + " Event name " + event.getEventTitle() + "\n");

	}

	/*public void displayByTimeRange() {
		System.out.print("\nRetrieve by time range between " + sdf.format(1414330846000L) + " and "
				+ sdf.format(1414590044999L));
		for (Event entry : eventService.retrieveByTimeRange(1414330846000L, 1414590044999L))
			System.out.print(
					"\nEvent ID = " + entry.getEventID() + ", " + (sdf.format(new Date(entry.getEventTime()))));

	}*/



}
