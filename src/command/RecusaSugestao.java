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

public class RecusaSugestao implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		int pIdSugestao = Integer.parseInt(request.getParameter("idSugestao"));
		String pFeedback = request.getParameter("feedback");
		
		Sugestao sugestao = new Sugestao();
		sugestao.setIdSugestao(pIdSugestao);
		
		SugestaoService ss = new SugestaoService();
		
		if(pFeedback == ""){
			pFeedback = "Sua sugestão foi recusada pelo avaliador.";
			
			RequestDispatcher view = null;
			HttpSession session = request.getSession();
			
			ss.recusar(pIdSugestao);
			ss.atualizaFeedback(pIdSugestao, pFeedback);
			sugestao = ss.carregar(sugestao.getIdSugestao());
			request.setAttribute("sugestao", sugestao);
			
			view = request.getRequestDispatcher("avaliarSugestoes.jsp");
			view.forward(request, response);
		}
		else{		
			RequestDispatcher view = null;
			HttpSession session = request.getSession();
			
			ss.recusar(pIdSugestao);
			ss.atualizaFeedback(pIdSugestao, pFeedback);
			sugestao = ss.carregar(sugestao.getIdSugestao());
			request.setAttribute("sugestao", sugestao);
			
			view = request.getRequestDispatcher("avaliarSugestoes.jsp");
			view.forward(request, response);
		}
	}
}