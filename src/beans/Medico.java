package beans;

import java.time.LocalDate;
import java.util.List;

public class Medico extends Usuario{
	private String cmr;
	private EspecialidadeEnum especialidade;
	private LocalTrabEnum localTrab;
	private List<Paciente> pacientes;
	private List<Consulta> consultas;

	public Medico(String nome, String userName, int id, String senha, char sexo, LocalDate dataNasc, String cmr,
			EspecialidadeEnum especialidade, LocalTrabEnum localTrab) {
		super(nome, userName, id, senha, sexo, dataNasc);
		this.cmr = cmr;
		this.especialidade = especialidade;
		this.localTrab = localTrab;
	}

	public String getCmr() {
		return cmr;
	}

	public void setCmr(String cmr) {
		this.cmr = cmr;
	}

	public EspecialidadeEnum getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(EspecialidadeEnum especialidade) {
		this.especialidade = especialidade;
	}
	
	public LocalTrabEnum getLocalTrab() {
		return localTrab;
	}

	public void setLocalTrab(LocalTrabEnum localTrab) {
		this.localTrab = localTrab;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
	public void addPaciente(Paciente paciente) {
		if(!this.getPacientes().contains(paciente)) {
			this.getPacientes().add(paciente);
		}
	}
	
	public void addConsultaEPaciente(Consulta con) {
		if(!this.getConsultas().contains(con)) {
			this.getConsultas().add(con);
			this.addPaciente(con.getPaciente());
		}
	}
}
