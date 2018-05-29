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



public class CarregaHomeCategoria implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		String pIdEspecialidade = request.getParameter("categoria");
		String pStatus = " = 'ativo' "; 
		
		CategoriaService cs = new CategoriaService();
		SugestaoService ss = new SugestaoService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		session.setAttribute("pIdEspecialidade", pIdEspecialidade);
		
		ArrayList<Categoria> lista = null;
		lista = cs.listarCategoria(pStatus);
		session.setAttribute("lista", lista);
		
		ArrayList<Sugestao> listaTop = null;
		listaTop = ss.listarTopSugestao();
		session.setAttribute("listaTop", listaTop);
		
		ArrayList<Sugestao> listaSugestao = null;
		listaSugestao = ss.listarSugestaoCategoria(pIdEspecialidade);
		session.setAttribute("listaSugestao", listaSugestao);
		
		view = request.getRequestDispatcher("sugestoes.jsp");
		view.forward(request, response);
		


	}

	public int busca(Categoria categoria, ArrayList<Categoria> lista) {
		Categoria to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == categoria.getId()) {
				return i;
			}
		}
		return -1;
	}

}