package pe.edu.uni.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import pe.edu.uni.model.ClinicaModel;
import pe.edu.uni.model.ComboModel;
import pe.edu.uni.service.ClinicaService;



@WebServlet({"/Procesar","/traerPrecio","/traerDsCurso","/traerCombos","/home"})
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<ComboModel> servicio;

	
	@Override
	public void init() throws ServletException {
		servicio= new ArrayList<>();
		servicio.add(new ComboModel(0,"SELECCIONAR"));
		servicio.add(new ComboModel(1,"Consulta Ambulatoria"));
		servicio.add(new ComboModel(2,"Consulta Emergencia"));
		servicio.add(new ComboModel(3,"Medicina Genérica"));
		servicio.add(new ComboModel(4,"Medicina de marca"));
		servicio.add(new ComboModel(5,"Medicina oncologica"));
		servicio.add(new ComboModel(6,"Laboratorio"));	
		servicio.add(new ComboModel(7,"Otros"));	
	}

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
    	String path = request.getServletPath();
		switch (path) {		  
		case "/traerCombos":
			traerCombos(request,response);
			break;
		case "/Procesar":
			procesar(request,response);
			break;	
		case "/home":
			cargarPaginaInicio(request, response);
			break;
		
		}
	}
	private void traerCombos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Preparando datos
				Map<String, Object> combos = new HashMap<>();
				combos.put("servicio", servicio);
				Gson gson = new Gson();
				String strJson = gson.toJson(combos);
				// Reporte
				response.setHeader("Content-Type", "application/json");
				PrintWriter writer = response.getWriter();
				writer.write(strJson);
				writer.close();
				
		
	}


	private void procesar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//variables	
				ClinicaModel model = new ClinicaModel();
				//datos
				 model.setServicio(Integer.parseInt(request.getParameter("servicio")));
				 model.setPrecio(Integer.parseInt(request.getParameter("precio")));
				 model.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
				 model.setTipocliente(Integer.parseInt(request.getParameter("tipocliente")));
				 model.setFrecuente(Boolean.valueOf(request.getParameter("frecuente")));
				 model.setDescripcion(String.format(request.getParameter("descripcion")));	
				
				//proceso
				ClinicaService service = new ClinicaService();
				model = service.procesar(model);
				// Reporte
				Gson gson = new Gson();
				String jsonString = gson.toJson(model);
				response.setHeader("Content-Type", "application/json");
			    PrintWriter writer = response.getWriter();
			    writer.write(jsonString);
			    writer.close();
				

	
	
	
	}
	

	
	
	
	private void cargarPaginaInicio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//cargarCombos(request);
		request.setAttribute("control", 1);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("index.html");
		rd.forward(request, response);
		
	}
}