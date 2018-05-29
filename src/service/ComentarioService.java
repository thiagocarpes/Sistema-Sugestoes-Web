package service;

import java.util.ArrayList;

import dao.ComentarioDAO;
import model.Comentario;

public class ComentarioService {
	ComentarioDAO dao = new ComentarioDAO();
	
	public int criar(Comentario comentario) {
		return dao.criar(comentario);
	}
	public ArrayList<Comentario> listarComentario(int idSugestao){
		return dao.listarComentario(idSugestao);
	}
}
