package sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import sistema.beans.EspecialidadeEnum;
import sistema.beans.Medico;
import sistema.connections.ConnectionFactory;

public class MedicoDAO {
	public Boolean create(Medico u) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			
			stmt = con.prepareStatement(
					"INSERT INTO medicos (login, senha, dataNascimento, sexo, email, nome, crm, especialidade, localTrab)VALUES(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, u.getLogin());
			stmt.setString(2, u.getSenha());
			stmt.setString(3, u.getDataNascString());
			stmt.setString(4, u.getSexo() == 'M' ? "M" : "F");
			stmt.setString(5, u.getEmail());
			stmt.setString(6, u.getNome());
			stmt.setString(7, u.getCrm());
			stmt.setString(8, u.getEspecialidadeString());
			stmt.setString(9, u.getLocalTrabString());
			stmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}

	public List<Medico> read() {

		Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Medico> medicos = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM medicos");
			rs = stmt.executeQuery();

			while (rs.next()) {
				
				Medico medico = new Medico();
				medico.setLogin(rs.getString("login"));
				medico.setDataNascimento(rs.getString("dataNascimento"));
				medico.setEmail(rs.getString("email"));
				medico.setSenha(rs.getString("senha"));
				medico.setSexo(rs.getString("sexo") == "M" ? 'M' : 'F');
				medico.setNome(rs.getString("nome"));
				medico.setCrm(rs.getString("crm"));
				medico.setEspecialidade(rs.getString("especialidade"));
				medico.setLocalTrab(rs.getString("localTrab"));
				medicos.add(medico);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return medicos;

	}

	public void update(Medico u) {

		Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"UPDATE medicos SET senha = ?,dataNascimento = ?, sexo = ?, email = ?, nome = ?, crm = ?, especialidade = ?, localTrab = ? WHERE login = ?");
			stmt.setString(1, u.getSenha());
			stmt.setString(2, u.getDataNascString());
			stmt.setString(3, u.getSexo() == 'M' ? "M" : "F");
			stmt.setString(4, u.getEmail());
			stmt.setString(5, u.getNome());
			stmt.setString(6, u.getCrm());
			stmt.setString(7, u.getEspecialidadeString());
			stmt.setString(8, u.getLocalTrabString());
			stmt.setString(9, u.getLogin());
			stmt.executeUpdate();

			// JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}

	public void delete(Medico u) {

		Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM medicos WHERE login = ?");
			stmt.setString(1, u.getLogin());

			stmt.executeUpdate();

			// JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}
	
	public List<Medico> medicosPorEspecialidade(EspecialidadeEnum esp) {

		Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Medico> medicos = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM medicos");
			rs = stmt.executeQuery();

			while (rs.next()) {
				
				if(esp.toString().contentEquals(rs.getString("especialidade"))) {
					
					Medico medico = new Medico();
					medico.setLogin(rs.getString("login"));
					medico.setDataNascimento(rs.getString("dataNascimento"));
					medico.setEmail(rs.getString("email"));
					medico.setSenha(rs.getString("senha"));
					medico.setSexo(rs.getString("sexo") == "M" ? 'M' : 'F');
					medico.setNome(rs.getString("nome"));
					medico.setCrm(rs.getString("crm"));
					medico.setEspecialidade(rs.getString("especialidade"));
					medico.setLocalTrab(rs.getString("localTrab"));
					medicos.add(medico);
					
				}
				
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return medicos;

	}
}
