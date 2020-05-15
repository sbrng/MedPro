package sistema.beans;

public class Medico extends Usuario {
	private String cmr;
	private String especialidade;
	private String localTrab;

	public Medico(String cmr, String especialidade, String localTrab) {
		this.cmr = cmr;
		this.especialidade = especialidade;
		this.localTrab = localTrab;
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

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getLocalTrab() {
		return localTrab;
	}

	public void setLocalTrab(String localTrab) {
		this.localTrab = localTrab;
	}

}
