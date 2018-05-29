package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Categoria;

public class CategoriaDAO {
	public int criar(Categoria categoria) {
		String sqlInsert = "INSERT INTO especialidade(nomeEspecialidade, corEspecialidade, status) VALUES(?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, categoria.getCategoria());
			stm.setString(2, categoria.getCor());
			stm.setString(3, "ativo");
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					categoria.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoria.getId();
	}	
	public Categoria carregar(int id) {
		Categoria categoria = new Categoria();
		categoria.setId(id);
		String sqlSelect = "select nomeEspecialidade, corEspecialidade from especialidade where idEspecialidade = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, categoria.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					categoria.setCategoria(rs.getString("nomeEspecialidade"));
					categoria.setCor(rs.getString("corEspecialidade"));
				} else {
					categoria.setId(-1);
					categoria.setCategoria(null);
					categoria.setCor(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return categoria;
	}
	
	public void atualizar(Categoria categoria) {
		String sqlUpdate = "update especialidade set nomeEspecialidade = ?, corEspecialidade = ? where idEspecialidade = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, categoria.getCategoria());
			stm.setString(2, categoria.getCor());
			stm.setInt(3, categoria.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Categoria carregarStatus(String status) {
		Categoria categoria = new Categoria();
		String sqlSelect = "select nomeEspecialidade, corEspecialidade from especialidade where status = "+status;
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					categoria.setCategoria(rs.getString("nomeEspecialidade"));
					categoria.setCor(rs.getString("corEspecialidade"));
				} else {
					categoria.setId(-1);
					categoria.setCategoria(null);
					categoria.setCor(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return categoria;
	}
	
	public ArrayList<Categoria> listarCategoria(String status) {
		Categoria categoria;
		ArrayList<Categoria> lista = new ArrayList<>();
		String sqlSelect = "SELECT idEspecialidade, nomeEspecialidade, corEspecialidade, especialidade.status as status FROM especialidade where status "+status;
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					categoria = new Categoria();
					categoria.setId(rs.getInt("idEspecialidade"));
					categoria.setCategoria(rs.getString("nomeEspecialidade"));
					categoria.setCor(rs.getString("corEspecialidade"));;
					categoria.setStatus(rs.getString("status"));
					lista.add(categoria);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	public ArrayList<Categoria> listarCategoriaStatus(String status) {
		Categoria categoria;
		ArrayList<Categoria> lista = new ArrayList<>();
		String sqlSelect = "SELECT idEspecialidade, nomeEspecialidade, corEspecialidade FROM especialidade where status"+status;
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					categoria = new Categoria();
					categoria.setId(rs.getInt("idEspecialidade"));
					categoria.setCategoria(rs.getString("nomeEspecialidade"));
					categoria.setCor(rs.getString("corEspecialidade"));;
					lista.add(categoria);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	public void inativarCategoria(int idCategoria) {
		String sqlUpdate = "update especialidade set status = 'inativo' where idEspecialidade = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, idCategoria);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void ativarCategoria(int idCategoria) {
		String sqlUpdate = "update especialidade set status = 'ativo' where idEspecialidade = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, idCategoria);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
