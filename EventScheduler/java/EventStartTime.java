

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.event.EventHelper;
import service.event.EventServiceImp;

/**
 * Servlet implementation class EventStartTime
 */
@WebServlet("/EventStartTime")
public class EventStartTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EventHelper eventHelper = new EventHelper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SerializerHelper serializer = new SerializerHelper();
		String result = serializer.javaObjectToJson(eventHelper.sortEventStartTime());
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}
}
