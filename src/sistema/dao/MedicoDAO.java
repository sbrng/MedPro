package sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import connections.ConnectionFactory;
import sistema.beans.Medico;

public class MedicoDAO {
	public Boolean create(Medico u) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String dataNasc = u.getDataNascimento().get(Calendar.DAY_OF_MONTH)+"/"+u.getDataNascimento().get(Calendar.MONTH)+"/"+u.getDataNascimento().get(Calendar.YEAR);
            
            stmt = con.prepareStatement("INSERT INTO medicos (login, senha, dataNascimento, sexo, email, nome, crm, especialidade, localTrab)VALUES(?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getSenha());
            stmt.setString(3, dataNasc);
            stmt.setString(4, u.getSexo()=='M'?"M":"F");
            stmt.setString(5, u.getEmail());
            stmt.setString(6, u.getNome());
            stmt.setString(7, u.getCmr());
            stmt.setString(8, u.getEspecialidade());
            stmt.setString(9, u.getLocalTrab());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
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
                String[] datas = rs.getString("dataNascimento").split("/");
                Calendar calendar = Calendar.getInstance();
                calendar.set(Integer.parseInt(datas[2]),Integer.parseInt(datas[1]),Integer.parseInt(datas[0]));

                Medico medico = new Medico();
                medico.setLogin(rs.getString("login"));
                medico.setDataNascimento(calendar);
                medico.setEmail(rs.getString("email"));
                medico.setSenha(rs.getString("senha"));
                medico.setSexo(rs.getString("sexo")=="M"?'M':'F');
                medico.setNome(rs.getString("nome"));
                medico.setCmr(rs.getString("crm"));
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
            stmt = con.prepareStatement("UPDATE medicos SET senha = ?,dataNascimento = ?, sexo = ?, email = ?, nome = ?, crm = ?, especialidade = ?, localTrab = ? WHERE login = ?");
            stmt.setString(1, u.getSenha());
            stmt.setString(2, u.getDataNascimento().get(Calendar.DAY_OF_MONTH)+"/"+u.getDataNascimento().get(Calendar.MONTH)+"/"+u.getDataNascimento().get(Calendar.YEAR));
            stmt.setString(3, u.getSexo()=='M'?"M":"F");
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getNome());
            stmt.setString(6, u.getLogin());
            stmt.setString(7, u.getCmr());
            stmt.setString(8, u.getEspecialidade());
            stmt.setString(9, u.getLocalTrab());
            stmt.executeUpdate();

            //JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
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

            //JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
