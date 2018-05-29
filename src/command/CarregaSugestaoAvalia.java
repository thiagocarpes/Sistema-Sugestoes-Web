package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Categoria;
import model.Sugestao;
import service.CategoriaService;
import service.SugestaoService;

public class CarregaSugestaoAvalia implements Command {
	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		int pIdEspecialidade = Integer.parseInt(request.getParameter("IdEspecialidade"));
		String pStatus = " = 'ativo' "; 
		
		CategoriaService cs = new CategoriaService();
		SugestaoService ss = new SugestaoService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ArrayList<Categoria> lista = null;
		lista = cs.listarCategoria(pStatus);
		session.setAttribute("lista", lista);
		
		ArrayList<Sugestao> listaSugestaoAvalia = null;
		listaSugestaoAvalia = ss.listarSugestaoAvalia(pIdEspecialidade);
		session.setAttribute("listaSugestaoAvalia", listaSugestaoAvalia);
		
		view = request.getRequestDispatcher("avaliarSugestao.jsp");
		view.forward(request, response);
		


	}
}