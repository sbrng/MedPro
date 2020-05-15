package sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import connections.ConnectionFactory;
import sistema.beans.Consulta;
import sistema.beans.Medico;

public class ConsultaDAO {
	public boolean create(Consulta u) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
    		   
        try {
        	String dataHora = u.getDataHora().get(Calendar.HOUR_OF_DAY)+":"+u.getDataHora().get(Calendar.MINUTE)+", "+u.getDataHora().get(Calendar.DAY_OF_MONTH)+"/"+u.getDataHora().get(Calendar.MONTH)+"/"+u.getDataHora().get(Calendar.YEAR);
			
        	stmt = con.prepareStatement("INSERT INTO consultas (medicoId, pacienteId, dataHora, localidade, sintomas)VALUES(?,?,?,?,?)");
			stmt.setString(1, u.getMedicoId());
			stmt.setString(2, u.getPacienteId());
			stmt.setString(3, dataHora);
			stmt.setString(4, u.getLocal());
			stmt.setString(5, u.getSintomas());
			stmt.executeUpdate();
			
			return true;
			
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
	}
		
	public List<Consulta> read(){
		
		Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Consulta> consultas = new ArrayList<Consulta>();
        
        try {
			stmt = con.prepareStatement("SELECT * FROM consultas");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				
                String[] timeData = rs.getString("dataHora").split(",\\s");
                String[] horaMin = timeData[0].split(":");
                String[] datas = timeData[1].split("/");
                Calendar calendar = Calendar.getInstance();
                calendar.set(Integer.parseInt(datas[2]),Integer.parseInt(datas[1]),Integer.parseInt(datas[0]), Integer.parseInt(horaMin[0]), Integer.parseInt(horaMin[1]));
                
                Consulta consulta = new Consulta();
                consulta.setId(rs.getInt("id"));
                consulta.setMedicoId(rs.getString("medicoId"));
                consulta.setPacienteId(rs.getString("pacienteId"));
                consulta.setDataHora(calendar);
                consulta.setLocal(rs.getString("localidade"));
                consulta.setSintomas(rs.getString("sintomas"));
                
                consultas.add(consulta);   
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
		return consultas; 
	}
		
	public void update(Consulta u) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
    		   
        try {
        	String dataHora = u.getDataHora().get(Calendar.HOUR_OF_DAY)+":"+u.getDataHora().get(Calendar.MINUTE)+", "+u.getDataHora().get(Calendar.DAY_OF_MONTH)+"/"+u.getDataHora().get(Calendar.MONTH)+"/"+u.getDataHora().get(Calendar.YEAR);
			
        	stmt = con.prepareStatement("UPDATE consultas SET medicoId = ?, pacienteId = ?, dataHora = ?, localidade = ?, sintomas = ? WHERE id = ?");
			stmt.setString(1, u.getMedicoId());
			stmt.setString(2, u.getPacienteId());
			stmt.setString(3, dataHora);
			stmt.setString(4, u.getLocal());
			stmt.setString(5, u.getSintomas());
			stmt.executeUpdate();
			
			
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
	}
	
	public void delete(Consulta u) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM consultas WHERE id = ?");
            stmt.setInt(1, u.getId());

            stmt.executeUpdate();

            //JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
		
}
