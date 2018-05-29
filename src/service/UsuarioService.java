package service;

import model.Usuario;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.UsuarioDAO;


public class UsuarioService {
	UsuarioDAO dao = new UsuarioDAO();
	
	public int criar(Usuario usuario) {
		return dao.criar(usuario);
	}
	public int criarAvaliador(Usuario usuario) {
		return dao.criarAvaliador(usuario);
	}
	public void atualizar(Usuario usuario){
		dao.atualizar(usuario);
	}
	public void atualizarAvaliador(Usuario usuario){
		dao.atualizarAvaliador(usuario);
	}
	public void inativar(int id){
		dao.inativar(id);
	}
	public void ativar(int id){
		dao.ativar(id);
	}
	public void excluir(int id){
		dao.excluir(id);
	}
	public ArrayList<Usuario> listarAvaliador(String status){
		return dao.listarAvaliador(status);
	}
	
	public Usuario carregar(int id){
		return dao.carregar(id);
	}
	
	public boolean login(String usuario, String senha, HttpServletRequest request){
		return dao.login(usuario, senha, request);
	}

}
