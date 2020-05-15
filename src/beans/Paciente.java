package beans;

import java.time.LocalDate;
import java.util.List;

public class Paciente extends Usuario {
	private List<Consulta> consultas;

	public Paciente(String nome, String userName, int id, String senha, char sexo, LocalDate dataNasc) {
		super(nome, userName, id, senha, sexo, dataNasc);
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
