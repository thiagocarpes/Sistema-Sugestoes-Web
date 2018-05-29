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

public class AlteraCategoria implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		int pIdCategora = Integer.parseInt(request.getParameter("idCategoria"));
		String pCategoria = request.getParameter("categoria");
		String pCor = request.getParameter("cor");
		
		Categoria categoria = new Categoria();
		categoria.setId(pIdCategora);
		categoria.setCategoria(pCategoria);
		categoria.setCor(pCor);
					
		CategoriaService cs = new CategoriaService();
				
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		cs.atualizar(categoria);
		cs.carregar(pIdCategora);
		request.setAttribute("categoria", categoria);
				
		view = request.getRequestDispatcher("controller.do?command=ListarCategoria&status= in ('ativo')");
		view.forward(request, response);
		


	}
}