import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.event.EventServiceImp;
import datastore.DataBaseException;
import generator.DataGenerator;
import model.Event;
import model.ParticipantDetails;
import com.google.appengine.api.datastore.EntityNotFoundException;

@WebServlet(name = "ScheduleEvent", urlPatterns = { "/event" })
public class ScheduleEvent extends HttpServlet {
	Event eventDetails = new Event();
	EventServiceImp eventService = new EventServiceImp();
	DataGenerator generator = new DataGenerator();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SerializerHelper serializer = new SerializerHelper();
		try {

			String result = serializer
					.javaObjectToJson(eventService.retrieveById(Long.valueOf(request.getParameter("id"))));
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(result);

		} catch (IllegalArgumentException | EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SerializerHelper serializer = new SerializerHelper();
		try {
			Event event = (Event) serializer.bufferedReaderToJavaObject(request.getReader());
			eventService.addEvent(event);
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print("Inserted event");

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} 
	}

	@Override
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SerializerHelper serializer = new SerializerHelper();
		try {
			Event event = (Event) serializer.bufferedReaderToJavaObject(request.getReader());
			eventService.modifyEvent(event);
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print("Modified  event");

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			eventService.removeEvent(Long.valueOf(request.getParameter("id")));
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print("Deleted");

		} catch (IllegalArgumentException | EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}