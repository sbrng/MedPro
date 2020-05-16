package sistema.beans;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

	public class Consulta {
	private Medico medico;
	private Paciente paciente;
	private LocalDateTime dataHora;
	private String local;
	private List<String> sintomas;
	private String anotacoes;

	public Consulta(Medico medico, Paciente paciente, LocalDateTime dataHora, String local) {
		this.medico = medico;
		this.paciente = paciente;
		this.dataHora = dataHora;
		this.local = local;
		
	}

	public Consulta(Medico medico, Paciente paciente, LocalDateTime dataHora, String local, List<String> sintomas,
			String anotacoes) {
		this.medico = medico;
		this.paciente = paciente;
		this.dataHora = dataHora;
		this.local = local;
		this.sintomas = sintomas;
		this.anotacoes = anotacoes;
	}
	
	public Consulta() {
		
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}
	
	public String getPacienteId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMedicoId() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public List<String> getSintomas() {
		return sintomas;
	}

	public void setSintomas(List<String> sintomas) {
		this.sintomas = sintomas;
	}

	public String getAnotacoes() {
		return anotacoes;
	}

	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}

	public void setMedicoId(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setId(int int1) {
		// TODO Auto-generated method stub
		
	}

	public void setDataHora(Calendar calendar) {
		// TODO Auto-generated method stub
		
	}

	public void setSintomas(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setPacienteId(String string) {
		// TODO Auto-generated method stub
		
	}



	

	

}
