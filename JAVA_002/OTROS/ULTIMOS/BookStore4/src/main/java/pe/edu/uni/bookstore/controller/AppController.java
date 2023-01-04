package pe.edu.uni.bookstore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import pe.edu.uni.bookstore.model.Mensaje;
import pe.edu.uni.bookstore.service.ValidaService;


@WebServlet({"/AppController", "/logon"})
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/logon":
			postLogon(request, response);
			break;

		default:
			break;
		}
	}

	private void postLogon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Datos
		String usuario = request.getParameter("username");
		String clave = request.getParameter("password");
		// Proceso
		ValidaService service = new ValidaService();
		int estado = service.validaUsuario(usuario, clave);
		Mensaje msg;
		if (estado == 1) {
			msg = new Mensaje(1, "Datos correctos.");
			HttpSession session = request.getSession(true);
			session.setAttribute("idempleado", usuario);
		} else {
			msg = new Mensaje(-1, "Datos incorrectos.");
		}
		Gson gson = new Gson();
		String strJson = gson.toJson(msg);
		HttpUtil.reporteJson(response, strJson);
	}
	
}
