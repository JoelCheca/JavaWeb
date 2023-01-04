package pe.edu.uni.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class HttpUtil {

	private HttpUtil() {
	}

	public static void reporteJson(HttpServletResponse response, String strJson) 
			throws IOException {
		response.setHeader("Content-Type", "application/json");
		PrintWriter writer = response.getWriter();
		writer.write(strJson);
		writer.close();
	}

}
