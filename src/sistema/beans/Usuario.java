package sistema.beans;

import java.io.Serializable;
import java.util.Calendar;

public class Usuario implements Serializable {
	private String Nome;
	private String Login;
	private String Senha;
	private Calendar DataNascimento;
	private String email;
	private char sexo;
	// private Image foto;

	public Usuario() {
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	/*
	 * public Image getFoto() { return foto; }
	 * 
	 * public void setFoto(Image foto) { this.foto = foto; }
	 */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario(String nome, String login, String senha, Calendar dataNascimento, char sexo, String email) {
		Nome = nome;
		Login = login;
		Senha = senha;
		DataNascimento = dataNascimento;
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
}
