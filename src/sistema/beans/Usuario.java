package sistema.beans;

//import android.media.Image;

import java.io.Serializable;
import java.util.Calendar;

public class Usuario implements Serializable {
    private String Nome;
    private String Login;
    private String Senha;
    private Calendar DataNascimento;
    private String email;
    private char sexo;
    //private Image foto;

    public Usuario() {
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
/*
    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }
*/
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public Usuario(String nome, String login, String senha, Calendar dataNascimento, String email, char sexo) {
		Nome = nome;
		Login = login;
		Senha = senha;
		DataNascimento = dataNascimento;
		this.email = email;
		this.sexo = sexo;
	}

    public Usuario(String nome, String login, String senha, String dataNascimento, char sexo, String email) {
        Nome = nome;
        Login = login;
        Senha = senha;
        setDataNascimento(dataNascimento);
        this.sexo = sexo;
        this.email = email;
    }

	public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public Calendar getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }
    
    public void setDataNascimento(String texto) {
    	String[] datas = texto.split("/");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(datas[2]), Integer.parseInt(datas[1]), Integer.parseInt(datas[0]));
		
		this.DataNascimento = calendar;
    }
    
    public String getDataNascString() {
    	String temp = this.getDataNascimento().get(Calendar.DAY_OF_MONTH) + "/"
				+ this.getDataNascimento().get(Calendar.MONTH) + "/" + this.getDataNascimento().get(Calendar.YEAR);
		return temp;
    }

	@Override
	public String toString() {
		return "Usuario [Nome=" + Nome + ", Login=" + Login + ", Senha=" + Senha + ", DataNascimento=" + this.getDataNascString()
				+ ", email=" + email + ", sexo=" + sexo + "]";
	}
    
    
    
}
