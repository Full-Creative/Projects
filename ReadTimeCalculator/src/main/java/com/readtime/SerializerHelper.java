package com.readtime;

import java.io.BufferedReader;
import java.io.IOException;

import com.google.gson.Gson;

public class SerializerHelper {
	protected String bufferedReaderToString(BufferedReader reader) throws IOException {
		StringBuilder buffer = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		return buffer.toString();
	}

	protected UserData bufferedReaderToJavaObject(BufferedReader reader) throws IOException {
		String javaString = bufferedReaderToString(reader);
		UserData data = new Gson().fromJson(javaString, UserData.class);
		return data;
	}

	protected String javaObjectToJson(ReadTimeData data) {
		String jsonString = new String();
		try {
			jsonString = new Gson().toJson(data);
		} catch (NullPointerException e) {
			System.out.print("Null pointer exception");
		}
		return jsonString;
	}
}
