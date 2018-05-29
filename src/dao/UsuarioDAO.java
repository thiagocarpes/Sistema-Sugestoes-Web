package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Usuario;

public class UsuarioDAO {
	public int criar(Usuario usuario) {
		String sqlInsert = "INSERT INTO usuarios(nome, senha, email, cpf, tipo, status) VALUES (?, ?, ?, ?, 1, 'ativo')";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, usuario.getNome());
			stm.setString(3, usuario.getEmail());
			stm.setString(4, usuario.getCpf());
			stm.setString(2, usuario.getSenha());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					usuario.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario.getId();
	}
	
	public int criarAvaliador(Usuario usuario) {
		String sqlInsert = "INSERT INTO usuarios(nome, senha, email, cpf, idEspecialidade, tipo, usuarios.status) VALUES (?, ?, ?, ?, ?, 2, 'ativo')";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getSenha());
			stm.setString(3, usuario.getEmail());
			stm.setString(4, usuario.getCpf());
			stm.setInt(5, usuario.getIdEspecialidade());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					usuario.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario.getId();
	}

	public void atualizar(Usuario usuario) {
		String sqlUpdate = "UPDATE usuarios SET nome=?, email=?, cpf=? WHERE idUsuario=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getCpf());
			stm.setInt(4, usuario.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarAvaliador(Usuario usuario) {
		String sqlUpdate = "UPDATE usuarios SET nome=?, email=?, cpf=?, idEspecialidade=? WHERE idUsuario=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getCpf());
			stm.setInt(4, usuario.getIdEspecialidade());
			stm.setInt(5, usuario.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void inativar(int id) {
		String sqlUpdate = "UPDATE usuarios SET usuarios.status= 'inativo' WHERE idUsuario="+id;
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void ativar(int id) {
		String sqlUpdate = "UPDATE usuarios SET usuarios.status= 'ativo' WHERE idUsuario="+id;
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE from usuarios where idUsuario = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario carregar(int id) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		String sqlSelect = "SELECT usuarios.nome as nome, usuarios.email as email, usuarios.senha as senha, usuarios.cpf as cpf, especialidade.nomeEspecialidade as especialidade, usuarios.idEspecialidade as idEspecialidade FROM usuarios left join especialidade on especialidade.idEspecialidade = usuarios.idEspecialidade WHERE idusuario = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, usuario.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					usuario.setCpf(rs.getString("senha"));
					usuario.setCpf(rs.getString("cpf"));
					usuario.setNomeEspecialidade(rs.getString("especialidade"));
					usuario.setIdEspecialidade(rs.getInt("idEspecialidade"));
				} else {
					usuario.setId(-1);
					usuario.setNome("nao_achei_esta_pega");
					usuario.setEmail(null);
					usuario.setCpf(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}
	
	public boolean login(String usuario, String senha, HttpServletRequest request) {
		
		String sqlSelect = "SELECT idusuario, nome, email, cpf, tipo, idEspecialidade FROM usuarios WHERE Email = ? AND senha = ? AND status = 'ativo'";
		// usando o try with resources do Java 7, que fecha o que abriu 
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			stm.setString(1, usuario);
			stm.setString(2, senha);			
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					
					Usuario user = new Usuario();
					user.setId(rs.getInt("idusuario"));
					user.setNome(rs.getString("nome"));
					user.setEmail(rs.getString("email"));
					user.setCpf(rs.getString("cpf"));
					
					HttpSession sessao = request.getSession();
					sessao.setAttribute("tipousuario", rs.getInt("tipo"));
					sessao.setAttribute("idusuario", rs.getInt("idusuario"));
					sessao.setAttribute("ObjectUsuario", user);					
					sessao.setAttribute("idespecialidade", rs.getInt("idespecialidade"));
					
					return true;
					
				}else{
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
			return false;
		}
		
	}
	
	
	public ArrayList<Usuario> listarAvaliador(String status) {
		Usuario usuario;
		ArrayList<Usuario> lista = new ArrayList<>();
		String sqlSelect = "select idUsuario, nome, email, especialidade.nomeEspecialidade as especialidade, usuarios.status as status from usuarios join especialidade on especialidade.idEspecialidade = usuarios.idEspecialidade where usuarios.status "+status;
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getInt("idUsuario"));
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));;
					usuario.setNomeEspecialidade(rs.getString("especialidade"));;
					usuario.setStatus(rs.getString("status"));;
					lista.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

}
