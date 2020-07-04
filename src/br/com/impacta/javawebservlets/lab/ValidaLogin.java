package br.com.impacta.javawebservlets.lab;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import br.com.impacta.javawebservlets.lab.bean.Usuario;

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
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		//Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Usuario usuario = (Usuario) request.getAttribute("usuario");
		
		if (usuario == null) {
			 usuario = new Usuario();
						usuario.setLogin(login);
			usuario.setSenha(senha);
			
			//request.getSession().setAttribute("usuario", usuario);
			request.setAttribute("usuario", usuario);
		}
				
				

					
		
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
