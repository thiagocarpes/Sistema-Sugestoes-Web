package service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import dao.SugestaoDAO;
import model.Sugestao;

public class SugestaoService {
	SugestaoDAO dao = new SugestaoDAO();
	
	public int novaSugestao(Sugestao sugestao) {
		return dao.novaSugestao(sugestao);
	}
	public ArrayList<Sugestao> listarTopSugestao(){
		return dao.listarTopSugestao();
	}
	public ArrayList<Sugestao> listarSugestao(){
		return dao.listarSugestao();
	}
	public ArrayList<Sugestao> listarSugestaoCategoria(String idEspecialidade){
		return dao.listarSugestaoCategoria(idEspecialidade);
	}
	public Sugestao carregar(int id){
		return dao.carregar(id);
	}
	public ArrayList<Sugestao> listarSugestaoUsuario(int idUsuario){
		return dao.listarSugestaoUsuario(idUsuario);
	}
	public ArrayList<Sugestao> listarSugestaoAvalia(int idEspecialidade){
		return dao.listarSugestaoAvalia(idEspecialidade);
	}
	public ArrayList<Sugestao> listarSugestaoCategoriaUsuario(String idEspecialidade, int idUsuario){
		return dao.listarSugestaoCategoriaUsuario(idEspecialidade, idUsuario);
	}	
	public ArrayList<Sugestao> participacao(){
		return dao.participacao();
	}
	public void aprovar(int idSugestao){
		dao.aprovar(idSugestao);
	}
	public void inativar(int idSugestao){
		dao.inativar(idSugestao);
	}
	public void recusar(int idSugestao){
		dao.recusar(idSugestao);
	}
	public void atualizaFeedback(int idSugestao, String feedback){
		dao.atualizaFeedback(idSugestao, feedback);
	}
	public ArrayList<Sugestao> sugestoesAprovadasCategoria(){
		return dao.sugestoesAprovadasCategoria();
	}
	public ArrayList<Sugestao> participacaoCategoria(int idEspecialidade){
		return dao.participacaoCategoria(idEspecialidade);
	}	
	public ArrayList<Sugestao> sugestoesGeralCategoria(){
		return dao.sugestoesGeralCategoria();
	}
	public ArrayList<Sugestao> listaSugestoesGeralAvaliador(HttpSession session){
		return dao.listaSugestoesGeralAvaliador(session);
	}
}
