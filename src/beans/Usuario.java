package beans;

import java.time.LocalDate;

public abstract class Usuario {
	private String nome;
	private String userName;
	private int id;
	private String senha;
	private char sexo;
	private LocalDate dataNasc;

	public Usuario(String nome, String userName, int id, String senha, char sexo, LocalDate dataNasc) {
		this.nome = nome;
		this.userName = userName;
		this.id = id;
		this.senha = senha;
		this.sexo = sexo;
		this.dataNasc = dataNasc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

}
