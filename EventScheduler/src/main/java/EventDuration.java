
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.EntityNotFoundException;

import service.event.EventServiceImp;

@WebServlet("/EventDuration")
public class EventDuration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EventServiceImp eventService = new EventServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SerializerHelper serializer = new SerializerHelper();
		String result = serializer.javaObjectToJson(eventService.sortDuration());
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);

	}
}
