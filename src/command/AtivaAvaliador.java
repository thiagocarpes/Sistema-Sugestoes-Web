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

public class AtivaAvaliador implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		int pIdUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		String pStatus = "= 'ativo'";
		
		Usuario usuario = new Usuario();
		usuario.setId(pIdUsuario);
		
		UsuarioService us = new UsuarioService();
				
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		us.ativar(pIdUsuario);
		
		ArrayList<Usuario> lista = null;
		lista = us.listarAvaliador(pStatus);
		session.setAttribute("lista", lista);

		
		view = request.getRequestDispatcher("avaliador.jsp");
		view.forward(request, response);
		


	}
}