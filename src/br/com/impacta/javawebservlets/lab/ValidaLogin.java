package br.com.impacta.javawebservlets.lab;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

/**
 * Servlet implementation class ValidaLogin
 */
@WebServlet("/valida-login")
public class ValidaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String senha = request.getParameter("senha");
		
		if (senha != null && senha.equals("impacta123")) {
			
			//ENCAMINHAR PARA A SERVLET SISTEMA - PAGINA PRINCIPAL DO SISTEMA
			RequestDispatcher rd = request.getRequestDispatcher("/sistema");
			rd.forward(request, response);
		}else {
			//REDIRECIONAR A REQUISIÇÃO PARA A PAGINA DE ERRO
			response.sendRedirect("http://localhost:8080/servlet-login/erroLogin.html");
		}
		
	}

}
