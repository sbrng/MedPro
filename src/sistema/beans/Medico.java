package sistema.beans;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public class Medico extends Usuario {
	private String cmr;
	private EspecialidadeEnum especialidade;
	private LocalTrabEnum localTrab;
	

	

	public Medico(String nome, String login, String senha, Calendar dataNascimento, char sexo, String email) {
		super(nome, login, senha, dataNascimento, sexo, email);
		// TODO Auto-generated constructor stub
		
	}

	public Medico() {
		// TODO Auto-generated constructor stub
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

	public void setEspecialidade(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setLocalTrab(String string) {
		// TODO Auto-generated method stub
		
	}

}
