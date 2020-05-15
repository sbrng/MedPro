package sistema.beans;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public class Paciente extends Usuario {
	private List<Consulta> consultas;

	

	public Paciente(String nome, String login, String senha, Calendar dataNascimento, char sexo, String email) {
		super(nome, login, senha, dataNascimento, sexo, email);
		// TODO Auto-generated constructor stub
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public void addConsulta(Consulta con) {
		this.getConsultas().add(con);
	}

}
