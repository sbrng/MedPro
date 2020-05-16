package sistema.beans;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import sistema.connections.ConnectionFactory;

import java.sql.Connection;

public class UsuarioDAO {
	private static UsuarioDAO singleInstance = null;
	private UsuarioDAO() {
		//H**** N**** F*****
	}
	public static UsuarioDAO getInstance() {
		if(singleInstance == null)
			singleInstance = new UsuarioDAO();
		return singleInstance;
	}
	
    public Boolean create(Usuario u) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String dataNasc = u.getDataNascimento().get(Calendar.DAY_OF_MONTH)+"/"+u.getDataNascimento().get(Calendar.MONTH)+"/"+u.getDataNascimento().get(Calendar.YEAR);
            stmt = con.prepareStatement("INSERT INTO Usuario VALUES(?,?,?,?,?,?)");
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getSenha());
            stmt.setString(3, dataNasc);
            stmt.setString(4, u.getSexo()=='M'?"M":"F");
            stmt.setString(5, u.getEmail());
            stmt.setString(6, u.getNome() );
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }

    }

    public List<Usuario> read() {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Usuario");
            rs = stmt.executeQuery();

            while (rs.next()) {
                String[] datas = rs.getString("DataNascimento").split("/");
                Calendar calendar = Calendar.getInstance();
                calendar.set(Integer.parseInt(datas[2]),Integer.parseInt(datas[1]),Integer.parseInt(datas[0]));

                Usuario produto = new Usuario();
                produto.setLogin(rs.getString("Login"));
                produto.setDataNascimento(calendar);
                produto.setEmail(rs.getString("Email"));
                produto.setSenha(rs.getString("Senha"));
                produto.setSexo(rs.getString("Sexo")=="M"?'M':'F');
                produto.setNome(rs.getString("Nome"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }

    public void update(Usuario u) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Usuario SET Senha = ?,DataNascimento = ?, Sexo = ?, Email = ?, Nome = ? WHERE Login = ?");
            stmt.setString(1, u.getSenha());
            stmt.setString(2, u.getDataNascimento().get(Calendar.DAY_OF_MONTH)+"/"+u.getDataNascimento().get(Calendar.MONTH)+"/"+u.getDataNascimento().get(Calendar.YEAR));
            stmt.setString(3, u.getSexo()=='M'?"M":"F");
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getNome());
            stmt.setString(6, u.getLogin());
            stmt.executeUpdate();

            //JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Usuario u) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Usuario WHERE login = ?");
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
