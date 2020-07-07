package br.com.impacta.javawebservlets.lab;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.impacta.javawebservlets.lab.bean.Usuario;

/**
 * Servlet implementation class SistemaServlet
 */
@WebServlet("/sistema")
public class SistemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		//Usuario usuario = (Usuario) request.getAttribute("usuario");
		Cookie[] cookies = request.getCookies();
		String cookEmail= null;
		
		//BUSCA DE UM COOKIE GRAVADO DE NOME EMAIL
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				
				if (cookie.getName().equals("email")) {
					
					cookEmail = cookie.getValue();
					break;
				}
			}
						
		}

		
		//CASO O VALOR NULO, DIRECIONA A REQUISIÇÃO PARA A SERVLET COM URL /colletaEmail
		
		if (cookEmail == null || cookEmail.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/coletaEmail");
			rd.forward(request, response);
		}
				
		response.getWriter().append("<HTML><BODY><H1>Bem Vindo " + usuario.getLogin() + "!")
							.append("<BR>Seu email é: " + cookEmail)
							.append("<BR>Esta é a pagina principal do sistema.")
							.append("<BR><BR><a href=\"/servlet-login/login.html\">Logout</a>")
							.append("</BODY></HTML");
	}

}
