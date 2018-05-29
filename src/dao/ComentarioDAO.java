package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comentario;
import model.Sugestao;

public class ComentarioDAO {
	public int criar(Comentario comentario) {
		String sqlInsert = "INSERT INTO comentarios (idUsuario, idSugestao, comentario) VALUES (?, ?, ?);";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, comentario.getColaborador());
			stm.setInt(2, comentario.getIdSugestao());
			stm.setString(3, comentario.getComentario());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					comentario.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comentario.getId();
	}
	public ArrayList<Comentario> listarComentario(int idSugestao) {
		Comentario comentario;
		Sugestao sugestao = null;
		ArrayList<Comentario> listaComentario = new ArrayList<>();
		String sqlSelect = "SELECT id, comentarios.idSugestao as idSugestao, usuarios.nome as Usuario, comentarios.comentario as Comentario FROM comentarios join usuarios on usuarios.idusuario = comentarios.idUsuario where idSugestao = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
					stm.setInt(1, idSugestao);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					comentario = new Comentario();
					comentario.setId(rs.getInt("id"));
					comentario.setIdSugestao(rs.getInt("idSugestao"));
					comentario.setUsuario(rs.getString("Usuario"));
					comentario.setComentario(rs.getString("Comentario"));;
					listaComentario.add(comentario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaComentario;
	}
	
}
