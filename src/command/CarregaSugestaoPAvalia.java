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

public class CarregaSugestaoPAvalia implements Command{
	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		int pId = Integer.parseInt(request.getParameter("id"));

		Sugestao sugestao = new Sugestao();
		sugestao.setIdSugestao(pId);
					
		SugestaoService ss = new SugestaoService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		sugestao = ss.carregar(sugestao.getIdSugestao());
		request.setAttribute("sugestao", sugestao);
				
		view = request.getRequestDispatcher("avaliarSugestoes.jsp");
		view.forward(request, response);
		

	}
}
