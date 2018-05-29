package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;





public class ListarAvaliador implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		String pStatus = request.getParameter("status");
		
		UsuarioService us = new UsuarioService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ArrayList<Usuario> lista = null;
		lista = us.listarAvaliador(pStatus);
		session.setAttribute("lista", lista);
		
		//System.out.println(lista.get(0));
		
		view = request.getRequestDispatcher("avaliador.jsp");
		view.forward(request, response);


	}
}
