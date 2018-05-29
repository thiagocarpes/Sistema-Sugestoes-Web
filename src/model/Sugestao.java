package model;

public class Sugestao{

   private int idSugestao;
   private int colaborador;
   private String nomeColaborador;
   private String titulo;
   private String sugestao;
   private String avaliador, feedback;
   private int especialidade;
   private String nomeEspecialidade;
   private int positivo;
   private int negativo;
   private String data;
   private String corEspecialidade;
   public static int idColaborador;
   private double pQuantidade;
   private int aprovadas;
   private int total;

private String status;
   
   public Sugestao() {
   }

   public Sugestao(int idSugestao, int colaborador, String titulo, String sugestao, String avaliador, String feedback,
		int especialidade, int positivo, int negativo) {
	this.idSugestao = idSugestao;
	this.colaborador = colaborador;
	this.titulo = titulo;
	this.sugestao = sugestao;
	this.avaliador = avaliador;
	this.feedback = feedback;
	this.especialidade = especialidade;
	this.positivo = positivo;
	this.negativo = negativo;
}

public int getIdSugestao() {
	return idSugestao;
}

public void setIdSugestao(int idSugestao) {
	this.idSugestao = idSugestao;
}

public int getColaborador() {
	return colaborador;
}

public void setColaborador(int colaborador) {
	this.colaborador = colaborador;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getSugestao() {
	return sugestao;
}

public void setSugestao(String sugestao) {
	this.sugestao = sugestao;
}

public String getAvaliador() {
	return avaliador;
}

public void setAvaliador(String avaliador) {
	this.avaliador = avaliador;
}

public String getFeedback() {
	return feedback;
}

public void setFeedback(String feedback) {
	this.feedback = feedback;
}

public int getEspecialidade() {
	return especialidade;
}

public void setEspecialidade(int especialidade) {
	this.especialidade = especialidade;
}

public int getPositivo() {
	return positivo;
}

public void setPositivo(int positivo) {
	this.positivo = positivo;
}

public int getNegativo() {
	return negativo;
}

public void setNegativo(int negativo) {
	this.negativo = negativo;
}

public static int getIdColaborador() {
	return idColaborador;
}

public static void setIdColaborador(int idColaborador) {
	Sugestao.idColaborador = idColaborador;
}

public String getData() {
	return data;
}

public void setData(String data) {
	this.data = data;
}

public String getNomeEspecialidade() {
	return nomeEspecialidade;
}

public void setNomeEspecialidade(String nomeEspecialidade) {
	this.nomeEspecialidade = nomeEspecialidade;
}

public String getCorEspecialidade() {
	return corEspecialidade;
}

public void setCorEspecialidade(String corEspecialidade) {
	this.corEspecialidade = corEspecialidade;
}

public String getNomeColaborador() {
	return nomeColaborador;
}

public void setNomeColaborador(String nomeColaborador) {
	this.nomeColaborador = nomeColaborador;
}

public double getpQuantidade() {
	return pQuantidade;
}

public void setpQuantidade(double pQuantidade) {
	this.pQuantidade = pQuantidade;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public int getAprovadas() {
	return aprovadas;
}

public void setAprovadas(int aprovadas) {
	this.aprovadas = aprovadas;
}
public int getTotal() {
	return total;
}

public void setTotal(int total) {
	this.total = total;
}   
   
   
}

