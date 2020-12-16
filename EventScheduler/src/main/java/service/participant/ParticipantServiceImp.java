package service.participant;

import model.Event;

import java.util.List;

import com.google.appengine.api.datastore.EntityNotFoundException;

import datastore.DataBaseException;
import datastore.EventsDB;
import model.ParticipantDetails;

public class ParticipantServiceImp implements ParticipantService {
	public EventsDB eventDB;

	public ParticipantServiceImp() {
		eventDB = new EventsDB();
	}

	@Override
	public ParticipantDetails createParticipant(ParticipantDetails participant) {
		if (participant == null || participant.getEmail() == null || participant.getName() == null)
			throw new IllegalArgumentException("Participant Details not available");
		eventDB.createParticipant(participant);
		return participant;
	}

	@Override
	public ParticipantDetails modifyParticipant(ParticipantDetails participant)
			throws DataBaseException, EntityNotFoundException {
		return null;
	}

	@Override
	public ParticipantDetails retrieveById(long id) throws EntityNotFoundException {
		return null;
	}

	@Override
	public void removeParticipant(String id) throws EntityNotFoundException {
	}

	public List<Event> retrieveEvents(String id) throws EntityNotFoundException {
		return eventDB.retrieveEventByEmail(id);
	}

}
