package sistema.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

	public class Consulta {
	private int id;
	private String medicoId;
	private String pacienteId;
	private Calendar dataHora;
	private LocalTrabEnum local;
	private List<String> sintomas;
	private String anotacoes;

	
	public Consulta() {
		
	}

	public Consulta(String medicoId, String pacienteId, Calendar dataHora, LocalTrabEnum local) {
		this.medicoId = medicoId;
		this.pacienteId = pacienteId;
		this.dataHora = dataHora;
		this.local = local;
	}
	
	public Consulta(String medicoId, String pacienteId, Calendar dataHora, String local) {
		this.medicoId = medicoId;
		this.pacienteId = pacienteId;
		this.dataHora = dataHora;
		this.local = LocalTrabEnum.valueOf(local);
	}

	public Consulta(int id, String medicoId, String pacienteId, Calendar dataHora, LocalTrabEnum local,
			List<String> sintomas, String anotacoes) {
		this.id = id;
		this.medicoId = medicoId;
		this.pacienteId = pacienteId;
		this.dataHora = dataHora;
		this.local = local;
		this.sintomas = sintomas;
		this.anotacoes = anotacoes;
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

	public LocalTrabEnum getLocal() {
		return local;
	}

	public void setLocal(LocalTrabEnum local) {
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
	
	public void setLocal(String local) {
		
		if(local!=null) {
			try{
				this.local = LocalTrabEnum.valueOf(local);
			}catch(Exception e){
				System.out.println("Erro ao converter para enum na classe consulta");
			}
		}
	}
	
	public String getLocalString() {
		return local.toString();
	}
	
	public String getDataHoraString() {
		
		String dataText = this.getDataHora().get(Calendar.HOUR_OF_DAY) + ":" + this.getDataHora().get(Calendar.MINUTE)
				+ ", " + this.getDataHora().get(Calendar.DAY_OF_MONTH) + "/" + this.getDataHora().get(Calendar.MONTH)
				+ "/" + this.getDataHora().get(Calendar.YEAR);
		return dataText;
	}

	public String getSintomasString() {
		String sintomasTxt = "";
		
		if(this.getSintomas() != null) {
			for(int i = 0; i < this.getSintomas().size(); i++) {
				
				if(i == this.getSintomas().size()-1) {
					sintomasTxt = sintomasTxt + this.getSintomas().get(i);
				}
				else {
					sintomasTxt = sintomasTxt + this.getSintomas().get(i) + ", ";
				}
			}
		}
		
		return sintomasTxt;
	}
	
	public void setSintomas(String text){
		List<String> sin = new ArrayList<String>();
		
		String[] partes = text.split(", ");
		
		for(String a : partes) {
			sin.add(a);
		}
		
		this.sintomas = sin;
	}
	
	public void setDataHora(String time) {
		String[] timeData = time.split(",\\s");
		String[] horaMin = timeData[0].split(":");
		String[] datas = timeData[1].split("/");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(datas[2]), Integer.parseInt(datas[1]), Integer.parseInt(datas[0]),
				Integer.parseInt(horaMin[0]), Integer.parseInt(horaMin[1]));
		this.dataHora = calendar;
	}
	
	@Override
	public String toString() {
		return "Consulta [id=" + id + ", medicoId=" + medicoId + ", pacienteId=" + pacienteId + ", dataHora=" + this.getDataHoraString()
				+ ", local=" + local + ", sintomas=" + sintomas + ", anotacoes=" + anotacoes + "]";
	}

}
