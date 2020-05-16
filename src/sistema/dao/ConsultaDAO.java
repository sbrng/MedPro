package sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import sistema.beans.Consulta;
import sistema.beans.Medico;
import sistema.beans.Usuario;
import sistema.connections.ConnectionFactory;

public class ConsultaDAO {
	public boolean create(Consulta u) {
		//sa, nao entendi oq foi feito aq, portanto n consegui ajeitar.
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			
			stmt = con.prepareStatement(
					"INSERT INTO consultas (medicoId, pacienteId, dataHora, localidade, sintomas, anotacoes)VALUES(?,?,?,?,?,?)");
			stmt.setString(1, u.getMedicoId());
			stmt.setString(2, u.getPacienteId());
			stmt.setString(3, u.getDataHoraString());
			stmt.setString(4, u.getLocalString());
			stmt.setString(5, u.getSintomasString());
			stmt.setString(6, u.getAnotacoes());
			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<Consulta> read() {

		Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Consulta> consultas = new ArrayList<Consulta>();

		try {
			stmt = con.prepareStatement("SELECT * FROM consultas");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Consulta consulta = new Consulta();
				consulta.setId(rs.getInt("id"));
				consulta.setMedicoId(rs.getString("medicoId"));
				consulta.setPacienteId(rs.getString("pacienteId"));
				consulta.setDataHora(rs.getString("dataHora"));
				consulta.setLocal(rs.getString("localidade"));
				consulta.setSintomas(rs.getString("sintomas"));
				consulta.setAnotacoes(rs.getString("anotacoes"));

				consultas.add(consulta);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return consultas;
	}
	

	public void update(Consulta u) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			
			stmt = con.prepareStatement(
					"UPDATE consultas SET medicoId = ?, pacienteId = ?, dataHora = ?, localidade = ?, sintomas = ?, anotacoes = ? WHERE id = ?");
			stmt.setString(1, u.getMedicoId());
			stmt.setString(2, u.getPacienteId());
			stmt.setString(3, u.getDataHoraString());
			stmt.setString(4, u.getLocalString());
			stmt.setString(5, u.getSintomasString());
			stmt.setString(6, u.getAnotacoes());
			stmt.setInt(7, u.getId());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void delete(Consulta u) {

		Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM consultas WHERE id = ?");
			stmt.setInt(1, u.getId());

			stmt.executeUpdate();

			// JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}
	
	public List<Consulta> consultasPorPaciente(Usuario u) {

		Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Consulta> consultas = new ArrayList<Consulta>();

		try {
			stmt = con.prepareStatement("SELECT * FROM consultas");
			rs = stmt.executeQuery();

			while (rs.next()) {
				
				if(u.getLogin().equals(rs.getString("pacienteId"))){
					
					Consulta consulta = new Consulta();
					
					consulta.setId(rs.getInt("id"));
					consulta.setMedicoId(rs.getString("medicoId"));
					consulta.setPacienteId(rs.getString("pacienteId"));
					consulta.setDataHora(rs.getString("dataHora"));
					consulta.setLocal(rs.getString("localidade"));
					consulta.setSintomas(rs.getString("sintomas"));
					consulta.setAnotacoes(rs.getString("anotacoes"));
	
					consultas.add(consulta);
				}
				
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return consultas;
	}
	
	public List<Consulta> consultasPorMedico(Medico u) {

		Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Consulta> consultas = new ArrayList<Consulta>();

		try {
			stmt = con.prepareStatement("SELECT * FROM consultas");
			rs = stmt.executeQuery();

			while (rs.next()) {
				
				if(u.getLogin().equals(rs.getString("medicoId"))){
					
					Consulta consulta = new Consulta();
					
					consulta.setId(rs.getInt("id"));
					consulta.setMedicoId(rs.getString("medicoId"));
					consulta.setPacienteId(rs.getString("pacienteId"));
					consulta.setDataHora(rs.getString("dataHora"));
					consulta.setLocal(rs.getString("localidade"));
					consulta.setSintomas(rs.getString("sintomas"));
					consulta.setAnotacoes(rs.getString("anotacoes"));
	
					consultas.add(consulta);
				}
				
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return consultas;
	}

}
