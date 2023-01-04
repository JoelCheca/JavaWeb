package pe.edu.uni.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.uni.bookstore.model.ComboModel;


@WebServlet({"/traerCombos"})
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<ComboModel> descripcion;  
	
	
	
	@Override
	public void init() throws ServletException {
		descripcion = new ArrayList<>();
		descripcion.add(new ComboModel(0,"SELECCIONAR"));
		descripcion.add(new ComboModel(1,"LIBRO"));
		descripcion.add(new ComboModel(2,"REVISTA"));
		descripcion.add(new ComboModel(3,"SEPARATA"));
			
	}

	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
	 case "/traerCombos":
			traerCombos(request,response);
			break;

		default:
			break;
		}
		
		
	}

	private void traerCombos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Preparando datos
				Map<String, Object> combos = new HashMap<>();
				combos.put("descripcion", descripcion);
				Gson gson = new Gson();
				String strJson = gson.toJson(combos);
				// Reporte
				response.setHeader("Content-Type", "application/json");
				PrintWriter writer = response.getWriter();
				writer.write(strJson);
				writer.close();		
	}
	

	
	
}
