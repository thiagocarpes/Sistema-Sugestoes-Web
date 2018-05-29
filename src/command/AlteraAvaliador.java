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

public class AlteraAvaliador implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		int pIdUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		String pCpf = request.getParameter("cpf");
		int pCategoria = Integer.parseInt(request.getParameter("categoria"));
		
		Usuario teste = new Usuario();
		teste.setId(pIdUsuario);
		teste.setNome(pNome);
		teste.setEmail(pEmail);
		teste.setIdEspecialidade(pCategoria);
		teste.setCpf(pCpf);
		
		//System.out.println(n+" "+e+" "+es+" "+cpf2);
					
		UsuarioService us = new UsuarioService();
				
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		us.atualizarAvaliador(teste);
		us.carregar(pIdUsuario);
		request.setAttribute("teste", teste);
				
		view = request.getRequestDispatcher("controller.do?command=ListarAvaliador&status= in ('ativo')");
		view.forward(request, response);
		


	}
}