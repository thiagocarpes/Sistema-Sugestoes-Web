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

public class AlteraUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		int pIdUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		String pCpf = request.getParameter("cpf");
		
		Usuario usuario = new Usuario();
		usuario.setId(pIdUsuario);
		usuario.setNome(pNome);
		usuario.setEmail(pEmail);
		usuario.setSenha(pSenha);
		usuario.setCpf(pCpf);
					
		UsuarioService us = new UsuarioService();
				
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		us.atualizar(usuario);
		us.carregar(pIdUsuario);
		request.setAttribute("usuario", usuario);
				
		view = request.getRequestDispatcher("controller.do?command=CarregaUsuario&"+pIdUsuario);
		view.forward(request, response);
		


	}
}