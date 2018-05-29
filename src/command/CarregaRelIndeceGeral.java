package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Sugestao;
import service.SugestaoService;

public class CarregaRelIndeceGeral implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		
		SugestaoService us = new SugestaoService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ArrayList<Sugestao> listaSugestoesGeralCategoria = null;
		listaSugestoesGeralCategoria = us.sugestoesGeralCategoria();
		session.setAttribute("listaSugestoesGeralCategoria", listaSugestoesGeralCategoria);
		
		view = request.getRequestDispatcher("indiceGeral.jsp");
		view.forward(request, response);


	}
}
