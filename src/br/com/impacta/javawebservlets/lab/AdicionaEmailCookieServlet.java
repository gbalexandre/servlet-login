package br.com.impacta.javawebservlets.lab;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdicionaEmailCookieServlet
 */
@WebServlet("/adicionaEmailCookie")
public class AdicionaEmailCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//RECUPERAR O PARAMETRO EMAIL ENVIADO NO FORMULARIO E ADICIONAR O VALOR COMO COOKIE NO BROWSER DO USUÁRIO
		
		String emailInformado = request.getParameter("email");
		Cookie cookieEmail = new Cookie("email",emailInformado);
		response.addCookie(cookieEmail);
		
		response.sendRedirect("http://localhost:8080/servlet-login/login.html");
		
	}

}
