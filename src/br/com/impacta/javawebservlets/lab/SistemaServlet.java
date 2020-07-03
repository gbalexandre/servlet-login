package br.com.impacta.javawebservlets.lab;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SistemaServlet
 */
@WebServlet("/sistema")
public class SistemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("<HTML><BODY><H1>Bem Vindo " + request.getParameter("login") + "!")
							.append("<BR>Esta � a pagina principal do sistema.")
							.append("<BR><BR><a href=\"/servlet-login/login.html\">Logout</a>")
							.append("</BODY></HTML");
	}

}