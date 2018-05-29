package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Categoria;
import service.CategoriaService;



public class CriarCategoria implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pCategoria = request.getParameter("categoria");
		String pCor = request.getParameter("cor");
		int id = -1;
		
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}
		String pStatus = " = 'ativo' "; 

		Categoria categoria = new Categoria();
		categoria.setId(id);
		categoria.setCategoria(pCategoria);
		categoria.setCor(pCor);
		CategoriaService cs = new CategoriaService();
		cs.criar(categoria);
		
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ArrayList<Categoria> lista = null;
		lista = cs.listarCategoria(pStatus);
		session.setAttribute("lista", lista);
				
		view = request.getRequestDispatcher("categorias.jsp");
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
