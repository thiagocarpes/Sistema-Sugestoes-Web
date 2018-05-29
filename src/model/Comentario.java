package model;

public class Comentario {
	private String comentario;
	private int id;
	private int colaborador;
	private int idSugestao;
	private String usuario;
	
	public Comentario(String comentario, int id, int colaborador, int idSugestao) {
		super();
		this.comentario = comentario;
		this.id = id;
		this.colaborador = colaborador;
		this.idSugestao = idSugestao;
	}
	public Comentario() {

	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getColaborador() {
		return colaborador;
	}
	public void setColaborador(int colaborador) {
		this.colaborador = colaborador;
	}
	public int getIdSugestao() {
		return idSugestao;
	}
	public void setIdSugestao(int idSugestao) {
		this.idSugestao = idSugestao;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
