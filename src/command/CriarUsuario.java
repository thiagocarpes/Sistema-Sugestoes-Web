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

public class CriarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		String pCpf = request.getParameter("cpf");
		String pSenha = request.getParameter("senha");
		String pConfirmaSenha = request.getParameter("confirmaSenha");
		
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}
		

		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome(pNome);
		usuario.setEmail(pEmail);
		usuario.setCpf(pCpf);
		usuario.setSenha(MD5.MD5(pSenha));
		usuario.setConfirmaSenha(MD5.MD5(pConfirmaSenha));
		UsuarioService us = new UsuarioService();
		
		
		
		if(usuario.getNome() != "" && usuario.getEmail() != "" && usuario.getCpf() != ""){
			if(usuario.getSenha() == usuario.getConfirmaSenha()){
				RequestDispatcher view = null;
				HttpSession session = request.getSession();
				us.criar(usuario);		
				view = request.getRequestDispatcher("controller.do?command=Login");
				view.forward(request, response);
			}
			else{
				RequestDispatcher view = null;
				HttpSession session = request.getSession();
				view = request.getRequestDispatcher("index.jsp?erro=3");
				view.forward(request, response);
				System.out.println(usuario.getSenha() +" "+ usuario.getConfirmaSenha());
			}
		}else{
			RequestDispatcher view = null;
			HttpSession session = request.getSession();
			view = request.getRequestDispatcher("index.jsp?erro=2");
			view.forward(request, response);
		}

	}
}
