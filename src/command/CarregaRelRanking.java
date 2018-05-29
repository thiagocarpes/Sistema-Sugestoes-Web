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

public class CarregaRelRanking implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		int pIdEspecialidade = Integer.parseInt(request.getParameter("IdEspecialidade"));
		
		SugestaoService us = new SugestaoService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ArrayList<Sugestao> listaParticipacaoCategoria = null;
		listaParticipacaoCategoria = us.participacaoCategoria(pIdEspecialidade);
		session.setAttribute("listaParticipacaoCategoria", listaParticipacaoCategoria);
		
		view = request.getRequestDispatcher("ranking.jsp");
		view.forward(request, response);


	}
}
