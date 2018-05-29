package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Categoria;
import model.Usuario;
import service.CategoriaService;
import service.UsuarioService;


public class CarregaAvaliador implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		int pIdUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		String pStatus = " = 'ativo' "; 
		
		Usuario usuario = new Usuario();
		usuario.setId(pIdUsuario);
					
		UsuarioService us = new UsuarioService();
		CategoriaService cs = new CategoriaService();
				
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ArrayList<Categoria> lista = null;
		lista = cs.listarCategoria(pStatus);
		session.setAttribute("lista", lista);
		
		usuario = us.carregar(pIdUsuario);
		request.setAttribute("usuario", usuario);
		
		request.setAttribute("idEspecialidade", usuario.getIdEspecialidade());
				
		view = request.getRequestDispatcher("editaAvaliador.jsp");
		view.forward(request, response);
		


	}
}