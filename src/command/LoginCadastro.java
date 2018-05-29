package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;
import model.MD5;

public class LoginCadastro implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		String cSenha = request.getParameter("confirmaSenha");
			
		UsuarioService user = new UsuarioService();
		
		if(senha == cSenha && email != null && nome != null && cpf != null){
			//user.login(email, MD5.MD5(senha), request);
			RequestDispatcher view = null;
			HttpSession session = request.getSession();
			view = request.getRequestDispatcher("controller.do?command=CriarUsuario");
			view.forward(request, response);
			
		}else{
		
			RequestDispatcher view = null;
			HttpSession session = request.getSession();
			view = request.getRequestDispatcher("index.jsp?erro=2");
			view.forward(request, response);
			
		}

	}

}
