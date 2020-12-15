

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.EntityNotFoundException;

import model.ParticipantDetails;
import service.event.EventServiceImp;

/**
 * Servlet implementation class ParticipantAddition
 */

@WebServlet(name = "ParticipantAddition", urlPatterns = { "/event/participant" })
public class ParticipantAddition extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SerializerHelper serializer = new SerializerHelper();
		ParticipantDetails participant = serializer.bufferedReaderToParticipantObject(request.getReader());
		EventServiceImp eventService = new EventServiceImp();
		try {
			eventService.addParticipant(participant);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	doGet(request, response);
	}

}
