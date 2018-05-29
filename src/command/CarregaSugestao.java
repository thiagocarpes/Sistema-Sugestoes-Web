package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comentario;
import model.Sugestao;
import service.ComentarioService;
import service.SugestaoService;


public class CarregaSugestao implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		int pId = Integer.parseInt(request.getParameter("id"));

		Sugestao sugestao = new Sugestao();
		sugestao.setIdSugestao(pId);
		
		Comentario comentario = new Comentario();
		comentario.setIdSugestao(pId);
			
		SugestaoService ss = new SugestaoService();
		ComentarioService cs = new ComentarioService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		sugestao = ss.carregar(sugestao.getIdSugestao());
		request.setAttribute("sugestao", sugestao);
		
		ArrayList<Comentario> listaComentario = null;
		listaComentario = cs.listarComentario(comentario.getIdSugestao());
		session.setAttribute("listaComentario", listaComentario);
		
		view = request.getRequestDispatcher("verMais.jsp");
		view.forward(request, response);
		


	}
}