package com.readtime;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TimeResult", urlPatterns = { "/time" })
public class TimeResult extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		SerializerHelper serializer = new SerializerHelper();
		try {
			UserData data = serializer.bufferedReaderToJavaObject(req.getReader());
			
			if (data.getText() == null || data.getType() == null) {
				throw new IllegalArgumentException("Invalid Input");
			} else {
				int count = new WordCounter().countWords(data.getText());

				ReadTimeFactory readTime = new ReadTimeFactory();
				double minutes = readTime.getReadType(data.getType()).calculateTime(count);

				ReadTimeData readTimeData = new ReadTimeData();
				readTimeData.setMinutes(minutes);
				readTimeData.setType(data.getType());

				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				resp.getWriter().write(serializer.javaObjectToJson(readTimeData));
			}

		} catch (NullPointerException e) {
			System.out.print("null value");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}
}
