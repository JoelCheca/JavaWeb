package pe.edu.uni.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.uni.model.SueldoModel;
import pe.edu.uni.service.SueldoService;




@WebServlet({"/Procesar" , "/home"})
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		String path = request.getServletPath();
		switch (path) {
		case "/Procesar":
			procesar(request,response);
			break;
		case "/home":
			cargarPaginaInicio(request, response);
			break;
		
		}

	}





	private void procesar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//variables	
				SueldoModel model = new SueldoModel();
				//datos
				model.setHorasDt(Integer.parseInt(request.getParameter("horasDt")));
				model.setDiasT(Integer.parseInt(request.getParameter("diasT")));	
				model.setPagoHoras(Double.parseDouble(request.getParameter("PagoHoras")));	
				model.setCanHijos(Integer.parseInt(request.getParameter("CanHijos")));			
			
				//proceso
				SueldoService service = new SueldoService();
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
			request.setAttribute("control", 1);
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
			
		}

}