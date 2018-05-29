package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MD5;
import model.Usuario;
import service.UsuarioService;

public class CriarAvaliador implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		int pCategoria = Integer.parseInt(request.getParameter("categoria"));
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		String pCpf = request.getParameter("cpf");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}
		String pStatus = "in ('ativo')";
		String ppSenha = MD5.MD5(pSenha);

		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome(pNome);
		usuario.setIdEspecialidade(pCategoria);
		usuario.setEmail(pEmail);
		usuario.setCpf(pCpf);
		usuario.setSenha(ppSenha);
		UsuarioService us = new UsuarioService();

		us.criarAvaliador(usuario);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ArrayList<Usuario> lista = null;
		lista = us.listarAvaliador(pStatus);
		session.setAttribute("lista", lista);
		
		view = request.getRequestDispatcher("avaliador.jsp");
		view.forward(request, response);
	}
}
