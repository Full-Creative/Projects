
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Song1
 */

@WebServlet(name = "FirstSong", urlPatterns = { "/song1" })
public class Song1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String artist = getServletConfig().getInitParameter("Artist");
		String album = getServletContext().getInitParameter("AlbumName");
		response.getWriter().append("Artist name: " + artist + "\nAlbum: " + album);
	
	}

}
