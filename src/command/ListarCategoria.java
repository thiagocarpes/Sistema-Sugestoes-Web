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



public class ListarCategoria implements Command {

	@Override
	public void executar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		String pStatus = request.getParameter("status"); 
				
		CategoriaService cs = new CategoriaService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ArrayList<Categoria> lista = null;
		lista = cs.listarCategoria(pStatus);
		session.setAttribute("lista", lista);
		
		//System.out.println(lista.get(0));
		
		view = request.getRequestDispatcher("categorias.jsp");
		view.forward(request, response);


	}

}
