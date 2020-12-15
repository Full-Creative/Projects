package model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class ParticipantDetails {
@Id	private String email;
	private String name;
	private long eventId;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof ParticipantDetails) {
			ParticipantDetails temp = (ParticipantDetails) obj;
			if (this.name.equals(temp.name) && this.email.equals( temp.email))
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (this.name.hashCode() + this.email.hashCode());
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
}
