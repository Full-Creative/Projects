

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.event.EventServiceImp;

/**
 * Servlet implementation class TimeRange
 */
@WebServlet("/TimeRange")
public class TimeRange extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EventServiceImp eventService = new EventServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SerializerHelper serializer = new SerializerHelper();
		String result = serializer.javaObjectToJson(eventService.retrieveByTimeRange(1414560045000L, 1414580045000L));
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

}
