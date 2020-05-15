package sistema.beans;

import java.util.Calendar;

public class Consulta {
	private int id;
	private String medicoId;
	private String pacienteId;
	private Calendar dataHora;
	private String local;
	private String sintomas;

	public Consulta(String medicoId, String pacienteId, Calendar dataHora, String local, String sintomas) {
		this.medicoId = medicoId;
		this.pacienteId = pacienteId;
		this.dataHora = dataHora;
		this.local = local;
		this.sintomas = sintomas;
	}

	public Consulta() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMedicoId() {
		return medicoId;
	}

	public void setMedicoId(String medicoId) {
		this.medicoId = medicoId;
	}

	public String getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(String pacienteId) {
		this.pacienteId = pacienteId;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	@Override
	public String toString() {
		return "Consulta [id=" + id + ", medicoId=" + medicoId + ", pacienteId=" + pacienteId + ", dataHora=" + dataHora
				+ ", local=" + local + ", sintomas=" + sintomas + "]";
	}

}
