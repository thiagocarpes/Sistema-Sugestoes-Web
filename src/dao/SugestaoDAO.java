package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Sugestao;

public class SugestaoDAO {
	Sugestao sugestao = new Sugestao();
	public int novaSugestao(Sugestao sugestao) {
		String sqlInsert = "INSERT INTO sugestao(colaborador, titulo, sugestao, especialidade, status, Data) VALUES (?, ?, ?, ?, 'inativo', NOW())";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, sugestao.getColaborador());
			stm.setString(2, sugestao.getTitulo());
			stm.setString(3, sugestao.getSugestao());
			stm.setInt(4, sugestao.getEspecialidade());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					sugestao.setIdSugestao(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sugestao.getIdSugestao();
	}
	public ArrayList<Sugestao> listarTopSugestao() {
		Sugestao sugestao;
		ArrayList<Sugestao> listaTop = new ArrayList<>();
		String sqlSelect = "select comentarios.idSugestao, DATE_FORMAT(sugestao.data, '%d/%m/%y') as data, count(comentarios.id),sugestao.titulo as titulo,sugestao.Sugestao as sugestao,especialidade.nomeEspecialidade as especialidade from comentarios join sugestao on sugestao.idSugestao = comentarios.idSugestao join especialidade on especialidade.idEspecialidade = sugestao.especialidade group by comentarios.idSugestao order by count(comentarios.id) desc limit 0,5";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					sugestao.setIdSugestao(rs.getInt("idSugestao"));
					sugestao.setTitulo(rs.getString("titulo"));
					sugestao.setSugestao(rs.getString("sugestao"));
					sugestao.setData(rs.getString("data"));
					sugestao.setNomeEspecialidade(rs.getString("especialidade"));
					listaTop.add(sugestao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaTop;
	}
	
	public ArrayList<Sugestao> listarSugestao() {
		Sugestao sugestao;
		ArrayList<Sugestao> listaTop = new ArrayList<>();
		String sqlSelect = "SELECT idSugestao, titulo, sugestao, DATE_FORMAT(sugestao.data, '%d/%m/%y') as data, especialidade.nomeEspecialidade as especialidade, especialidade.corEspecialidade as cor FROM sugestao join especialidade on especialidade.idEspecialidade = sugestao.Especialidade WHERE sugestao.status='ativo' order by data desc";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					sugestao.setIdSugestao(rs.getInt("idSugestao"));
					sugestao.setTitulo(rs.getString("titulo"));
					if(rs.getString("sugestao").length() < 95){
						sugestao.setSugestao(rs.getString("sugestao"));
					}else{
						sugestao.setSugestao(rs.getString("sugestao").substring(0, 95)+"...");
					}
					sugestao.setData(rs.getString("data"));
					sugestao.setNomeEspecialidade(rs.getString("especialidade"));
					sugestao.setCorEspecialidade(rs.getString("cor"));
					listaTop.add(sugestao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaTop;
	}
	public ArrayList<Sugestao> listarSugestaoCategoria(String idEspecialidade) {
		Sugestao sugestao;
		ArrayList<Sugestao> listaTop = new ArrayList<>();
		String sqlSelect = "SELECT idSugestao, titulo, sugestao, DATE_FORMAT(sugestao.data, '%d/%m/%y') as data, especialidade.nomeEspecialidade as especialidade, especialidade.corEspecialidade as cor FROM sugestao join especialidade on especialidade.idEspecialidade = sugestao.Especialidade WHERE sugestao.status='ativo' and sugestao.Especialidade " + idEspecialidade + "  order by data desc";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					sugestao.setIdSugestao(rs.getInt("idSugestao"));
					sugestao.setTitulo(rs.getString("titulo"));
					if(rs.getString("sugestao").length() < 95){
						sugestao.setSugestao(rs.getString("sugestao"));
					}else{
						sugestao.setSugestao(rs.getString("sugestao").substring(0, 95)+"...");
					}
					sugestao.setData(rs.getString("data"));
					sugestao.setNomeEspecialidade(rs.getString("especialidade"));
					sugestao.setCorEspecialidade(rs.getString("cor"));
					listaTop.add(sugestao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaTop;
	}
	public ArrayList<Sugestao> listarSugestaoCategoriaUsuario(String idEspecialidade, int idUsuario) {
		Sugestao sugestao;
		ArrayList<Sugestao> listaSugestaoUsuarioCategoria = new ArrayList<>();
		String sqlSelect = "SELECT idSugestao, titulo, sugestao, DATE_FORMAT(sugestao.data, '%d/%m/%y') as data, especialidade.nomeEspecialidade as especialidade, especialidade.corEspecialidade as cor, sugestao.status as status, sugestao.Colaborador FROM sugestao join especialidade on especialidade.idEspecialidade = sugestao.Especialidade WHERE sugestao.Especialidade  "+idEspecialidade+" and sugestao.Colaborador = " + idUsuario;
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					sugestao.setIdSugestao(rs.getInt("idSugestao"));
					sugestao.setTitulo(rs.getString("titulo"));
					sugestao.setColaborador(rs.getInt("colaborador"));
					if(rs.getString("sugestao").length() < 95){
						sugestao.setSugestao(rs.getString("sugestao"));
					}else{
						sugestao.setSugestao(rs.getString("sugestao").substring(0, 95)+"...");
					}
					sugestao.setData(rs.getString("data"));
					sugestao.setNomeEspecialidade(rs.getString("especialidade"));
					sugestao.setCorEspecialidade(rs.getString("cor"));
					listaSugestaoUsuarioCategoria.add(sugestao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaSugestaoUsuarioCategoria;
	}
	
	public ArrayList<Sugestao> listarSugestaoAvalia(int idEspecialidade) {
		Sugestao sugestao = new Sugestao();
		ArrayList<Sugestao> listaSugestaoAvalia = new ArrayList<>();
		String sqlSelect = "SELECT idSugestao, titulo, sugestao, DATE_FORMAT(sugestao.data, '%d/%m/%y') as data, especialidade.nomeEspecialidade as especialidade, especialidade.corEspecialidade as cor, sugestao.status as status FROM sugestao join especialidade on especialidade.idEspecialidade = sugestao.Especialidade WHERE especialidade.idEspecialidade = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, idEspecialidade);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					sugestao.setIdSugestao(rs.getInt("idSugestao"));
					sugestao.setTitulo(rs.getString("titulo"));
					if(rs.getString("sugestao").length() < 145){
						sugestao.setSugestao(rs.getString("sugestao"));
					}else{
						sugestao.setSugestao(rs.getString("sugestao").substring(0, 145)+"...");
					}
					sugestao.setData(rs.getString("data"));
					sugestao.setNomeEspecialidade(rs.getString("especialidade"));
					sugestao.setCorEspecialidade(rs.getString("cor"));
					sugestao.setStatus(rs.getString("status"));
					listaSugestaoAvalia.add(sugestao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaSugestaoAvalia;
	}
	public ArrayList<Sugestao> listarSugestaoUsuario(int idUsuario) {
		Sugestao sugestao = new Sugestao();
		ArrayList<Sugestao> listaSugestaoUsuario = new ArrayList<>();
		String sqlSelect = "SELECT idSugestao, titulo, sugestao, DATE_FORMAT(sugestao.data, '%d/%m/%y') as data, especialidade.nomeEspecialidade as especialidade, especialidade.corEspecialidade as cor, sugestao.status as status FROM sugestao join especialidade on especialidade.idEspecialidade = sugestao.Especialidade WHERE sugestao.Colaborador = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, idUsuario);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					sugestao.setIdSugestao(rs.getInt("idSugestao"));
					sugestao.setTitulo(rs.getString("titulo"));
					if(rs.getString("sugestao").length() < 150){
						sugestao.setSugestao(rs.getString("sugestao"));
					}else{
						sugestao.setSugestao(rs.getString("sugestao").substring(0, 150)+"...");
					}
					sugestao.setData(rs.getString("data"));
					sugestao.setNomeEspecialidade(rs.getString("especialidade"));
					sugestao.setCorEspecialidade(rs.getString("cor"));
					sugestao.setStatus(rs.getString("status"));
					listaSugestaoUsuario.add(sugestao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaSugestaoUsuario;
	}
	public Sugestao carregar(int id) {
		Sugestao sugestao = new Sugestao();
		sugestao.setIdSugestao(id);
		String sqlSelect = "SELECT idSugestao, titulo, sugestao, status, feedback FROM sugestao WHERE idSugestao = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, sugestao.getIdSugestao());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					sugestao.setTitulo(rs.getString("titulo"));
					sugestao.setSugestao(rs.getString("sugestao"));
					sugestao.setStatus(rs.getString("status"));
					if(rs.getString("feedback") == null ){
						sugestao.setFeedback("O avaliador responsável ainda não passou um feedback para a sua sugestão.");
					}else{
						sugestao.setFeedback(rs.getString("feedback"));
					}
				} else {
					sugestao.setIdSugestao(-1);
					sugestao.setTitulo(null);
					sugestao.setSugestao(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return sugestao;
	}
	
	public ArrayList<Sugestao> participacao() {
		Sugestao sugestao;
		ArrayList<Sugestao> listaParticipacao = new ArrayList<>();
		String sqlSelect = "SELECT usuarios.nome as nome, count(sugestao.Colaborador) as quantidade from sugestao join usuarios on usuarios.idusuario = sugestao.Colaborador group by sugestao.Colaborador order by quantidade desc;";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					sugestao.setNomeColaborador(rs.getString("nome"));
					sugestao.setpQuantidade(rs.getInt("quantidade"));
					listaParticipacao.add(sugestao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaParticipacao;
	}
	
	public ArrayList<Sugestao> sugestoesAprovadasCategoria() {
		Sugestao sugestao;
		ArrayList<Sugestao> listaSugestoesAprovadasCategoria = new ArrayList<>();
		String sqlSelect = "select especialidade.nomeEspecialidade as especialidade, count(sugestao.Especialidade) as quantidade from sugestao join especialidade on sugestao.Especialidade = especialidade.idEspecialidade where sugestao.status = 'ativo' group by sugestao.Especialidade order by quantidade desc;";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					sugestao.setNomeEspecialidade(rs.getString("Especialidade"));
					sugestao.setAprovadas(rs.getInt("quantidade"));
					listaSugestoesAprovadasCategoria.add(sugestao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaSugestoesAprovadasCategoria;
	}
	
	public ArrayList<Sugestao> sugestoesGeralCategoria() {
		Sugestao sugestao;
		ArrayList<Sugestao> listaSugestoesGeralCategoria = new ArrayList<>();
		sugestoesAprovadasCategoria();
		String sqlSelect = "SELECT especialidade.nomeEspecialidade as Nome, count(sugestao.Especialidade) as quantidade, sugestao.Especialidade FROM"
				+ " sugestao JOIN especialidade on sugestao.Especialidade = especialidade.idEspecialidade"
				+ " group by sugestao.Especialidade order by quantidade desc;";
		
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					
					//conta as sugestoes aprovadas
					String sqlSelect2 = "SELECT count(sugestao.Especialidade) AS total FROM"
							+ " sugestao JOIN especialidade on sugestao.Especialidade = especialidade.idEspecialidade"
							+ " WHERE sugestao.Especialidade ="+rs.getInt("Especialidade")+" AND sugestao.status='ativo';";
					PreparedStatement stm2 = conn.prepareStatement(sqlSelect2);
					try (ResultSet rs2 = stm2.executeQuery(sqlSelect2);) {
						
						if(rs2.next()) sugestao.setAprovadas(rs2.getInt("total"));
						
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					//----------------------------------
					double pTotal = 0.0;
					
					if(sugestao.getAprovadas() == 0){
						pTotal = 0;
					}else{
						pTotal = (sugestao.getAprovadas() * 100) / rs.getInt("quantidade");
					}
					
					sugestao.setpQuantidade(pTotal);
					sugestao.setTotal(rs.getInt("quantidade"));
					sugestao.setNomeEspecialidade(rs.getString("Nome"));
					listaSugestoesGeralCategoria.add(sugestao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaSugestoesGeralCategoria;
	}
	
	public ArrayList<Sugestao> listaSugestoesGeralAvaliador(HttpSession session) {
		Sugestao sugestao;
		ArrayList<Sugestao> listaSugestoesGeralCategoria = new ArrayList<>();
		sugestoesAprovadasCategoria();		
	
		int idespecialidade = (int)session.getAttribute("idespecialidade");
		
		String sqlSelect = "SELECT usuarios.nome, count(sugestao.Especialidade) as quantidade, sugestao.Especialidade, usuarios.idusuario FROM"
				+ " sugestao JOIN usuarios ON sugestao.Colaborador = usuarios.idusuario"
				+ " WHERE sugestao.Especialidade = "+idespecialidade
				+ " group by sugestao.Especialidade order by quantidade desc;";
		
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					
					//conta as sugestoes aprovadas
					String sqlSelect2 = "SELECT count(sugestao.Especialidade) AS total FROM"
							+ " sugestao JOIN usuarios on sugestao.Colaborador = usuarios.idusuario"
							+ " WHERE sugestao.Colaborador ="+rs.getInt("idusuario")+" AND sugestao.status='ativo';";
					PreparedStatement stm2 = conn.prepareStatement(sqlSelect2);
					try (ResultSet rs2 = stm2.executeQuery(sqlSelect2);) {
						
						if(rs2.next()) sugestao.setAprovadas(rs2.getInt("total"));
						
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					//----------------------------------
					double pTotal = 0.0;
					
					if(sugestao.getAprovadas() == 0){
						pTotal = 0;
					}else{
						pTotal = (sugestao.getAprovadas() * 100) / rs.getInt("quantidade");
					}
					
					sugestao.setpQuantidade(pTotal);
					sugestao.setTotal(rs.getInt("quantidade"));
					sugestao.setNomeColaborador(rs.getString("nome"));
					listaSugestoesGeralCategoria.add(sugestao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaSugestoesGeralCategoria;
	}

	
	public ArrayList<Sugestao> participacaoCategoria(int idEspecialidad) {
		Sugestao sugestao;
		ArrayList<Sugestao> listaParticipacaoCategoria = new ArrayList<>();
		String sqlSelect = "SELECT usuarios.nome as nome, count(sugestao.Colaborador) as quantidade, sugestao.colaborador from sugestao join usuarios on usuarios.idusuario = sugestao.Colaborador where sugestao.Especialidade = "+ idEspecialidad +" order by quantidade desc";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					sugestao = new Sugestao();
					sugestao.setNomeColaborador(rs.getString("nome"));
					sugestao.setpQuantidade(rs.getInt("quantidade"));
					listaParticipacaoCategoria.add(sugestao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaParticipacaoCategoria;
	}
	
	public void aprovar(int idSugestao) {
		String sqlUpdate = "update sugestao set status = 'ativo' where idSugestao = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, idSugestao);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void inativar(int idSugestao) {
		String sqlUpdate = "update sugestao set status = 'inativa' where idSugestao = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, idSugestao);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void recusar(int idSugestao) {
		String sqlUpdate = "update sugestao set status = 'recusada' where idSugestao = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, idSugestao);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void atualizaFeedback(int idSugestao, String feedback) {
		String sqlUpdate = "update sugestao set feedback = ? where idSugestao = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, feedback);
			stm.setInt(2, idSugestao);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
