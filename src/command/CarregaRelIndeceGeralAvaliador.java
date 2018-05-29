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

public class CarregaRelIndeceGeralAvaliador implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		
		SugestaoService us = new SugestaoService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ArrayList<Sugestao> listaSugestoesGeralAvaliador = null;
		listaSugestoesGeralAvaliador = us.listaSugestoesGeralAvaliador(session);
		session.setAttribute("listaSugestoesGeralAvaliador", listaSugestoesGeralAvaliador);
		
		view = request.getRequestDispatcher("indiceGeralAvaliador.jsp");
		view.forward(request, response);


	}
}
