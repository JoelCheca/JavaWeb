	package pe.edu.uni.app.controller;

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

import pe.edu.uni.app.Model.ComboModel;
import pe.edu.uni.app.Model.ComisionModel;
import pe.edu.uni.app.service.ComisionService;
	



@WebServlet({"/Procesar","/traerPrecio","/traerDsCurso","/traerCombos","/home"})
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<ComboModel> cat;
	
	
       
  
	@Override
	public void init() throws ServletException {
		cat = new ArrayList<>();
		cat.add(new ComboModel(0,"SELECCIONAR"));
		cat.add(new ComboModel(1,"1.PROGRAMACIÓN"));
		cat.add(new ComboModel(2,"2.OFIMÁTICA"));
		cat.add(new ComboModel(3,"3.ADMINISTRACIÓN"));
		cat.add(new ComboModel(4,"4.OTROS"));		
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
		case "/traerPrecio":
			traerPrecio(request,response);
			break;
		case "/traerDsCurso":
			traerDsCurso(request,response);
			break;
		case "/home":
			cargarPaginaInicio(request, response);
			break;
		
		}
		
		
	}
    
    
    
    

	private void traerCombos(HttpServletRequest request, HttpServletResponse response)throws IOException {
		// Preparando datos
		Map<String, Object> combos = new HashMap<>();
		combos.put("cat", cat);
		Gson gson = new Gson();
		String strJson = gson.toJson(combos);
		// Reporte
		response.setHeader("Content-Type", "application/json");
		PrintWriter writer = response.getWriter();
		writer.write(strJson);
		writer.close();
		
	}

	private void traerDsCurso(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
				// Datos
				int categoria = Integer.parseInt(request.getParameter("categoria"));
				int item = Integer.parseInt(request.getParameter("item"));
				// Proceso
				ComisionService service = new ComisionService ();
				String descrip = switch(categoria){
					case 1 -> service.descrip(item);
					case 2 -> service.descrip(item);
					case 3 -> service.descrip(item);
					case 4 -> service.descrip(item);
					default -> "No existe"; 
				};
				// Reporte
				String reporte = "" + descrip;
				response.setHeader("Content-Type", "text/plain");
			    PrintWriter writer = response.getWriter();
			    writer.write(reporte);
			    writer.close();
		
		
	}

	private void traerPrecio(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		// Datos
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		int item = Integer.parseInt(request.getParameter("item"));
		// Proceso
		ComisionService service = new ComisionService ();
		double precio = switch(categoria){
			case 1 -> service.precio(item);
			case 2 -> service.precio(item);
			case 3 -> service.precio(item);
			case 4 -> service.precio(item);
			default -> 0.0; };
			// Reporte
			String reporte = "S/" +"  "+ precio;
			response.setHeader("Content-Type", "text/plain");
		    PrintWriter writer = response.getWriter();
		    writer.write(reporte);
		    writer.close();
		
		
	}
    
    
 

	private void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables	
		ComisionModel model = new ComisionModel();
		//datos
		model.setPart(Integer.parseInt(request.getParameter("part")));
		model.setCat(Integer.parseInt(request.getParameter("cat")));	
		
		//proceso
		ComisionService service = new ComisionService();
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
