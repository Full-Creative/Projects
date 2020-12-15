
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.gson.Gson;

import model.Event;
import model.ParticipantDetails;
import service.participant.*;

/**
 * Servlet implementation class Participant
 */

@WebServlet(name = "ParticipantCreation", urlPatterns = { "/participant" })
public class ParticipantCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SerializerHelper serializer = new SerializerHelper();
		ParticipantDetails participant = serializer.bufferedReaderToParticipantObject(request.getReader());
		ParticipantServiceImp participantService = new ParticipantServiceImp();
		participantService.createParticipant(participant);
		
		// doGet(request, response);
	}

}
