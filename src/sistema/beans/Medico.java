package sistema.beans;

import java.util.Calendar;

public class Medico extends Usuario {
	private String crm;
	private EspecialidadeEnum especialidade;
	private LocalTrabEnum localTrab;
	
	public Medico(String crm, EspecialidadeEnum especialidade, LocalTrabEnum localTrab) {
		this.crm = crm;
		this.especialidade = especialidade;
		this.localTrab = localTrab;
	}

	public Medico(String nome, String login, String senha, Calendar dataNascimento, String email, char sexo) {
		super(nome, login, senha, dataNascimento, email, sexo);
	}

	public Medico(String nome, String login, String senha, String dataNascimento, char sexo, String email) {
		super(nome, login, senha, dataNascimento, sexo, email);
	}
	
	public Medico(String nome, String login, String senha, Calendar dataNascimento, String email, char sexo, String crm,
			EspecialidadeEnum especialidade, LocalTrabEnum localTrab) {
		super(nome, login, senha, dataNascimento, email, sexo);
		this.crm = crm;
		this.especialidade = especialidade;
		this.localTrab = localTrab;
	}

	public Medico() {
	
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
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
	
	public void setLocalTrab(String localTrab) {
		this.localTrab = LocalTrabEnum.valueOf(localTrab);
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = EspecialidadeEnum.valueOf(especialidade);
	}
	
	public String getLocalTrabString() {
		return localTrab.toString();
	}
	
	public String getEspecialidadeString() {
		return especialidade.toString();
	}

	@Override
	public String toString() {
		return "Medico [crm=" + crm + ", especialidade=" + especialidade + ", localTrab=" + localTrab + "]";
	}
	
	
}
