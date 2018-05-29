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

public class ListarTopSugestoes implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		
		SugestaoService ss = new SugestaoService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ArrayList<Sugestao> listaTop = null;
		listaTop = ss.listarTopSugestao();
		session.setAttribute("listaTop", listaTop);
		
		view = request.getRequestDispatcher("sugestoes.jsp");
		view.forward(request, response);


	}

	public int busca(Sugestao sugestao, ArrayList<Sugestao> listaTop) {
		Sugestao to;
		for (int i = 0; i < listaTop.size(); i++) {
			to = listaTop.get(i);
			if (to.getIdSugestao() == sugestao.getIdSugestao()) {
				return i;
			}
		}
		return -1;
	}

}
