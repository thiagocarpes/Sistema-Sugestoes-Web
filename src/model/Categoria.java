package model;

import java.io.Serializable;

public class Categoria implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String categoria;
	private String cor;
	private String status;
	
	public Categoria() {
		
	}
	public Categoria(int id, String categoria, String cor) {
		this.id = id;
		this.categoria = categoria;
		this.cor = cor;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
