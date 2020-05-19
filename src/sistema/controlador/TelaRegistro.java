package sistema.controlador;

import sistema.beans.Medico;

public class TelaRegistro {
	
	private static TelaRegistro singleInstance = null;
	private Medico medico;

	private TelaRegistro() {
	}

	public static TelaRegistro getInstance() {
		if(singleInstance == null)
			singleInstance = new TelaRegistro();
		return singleInstance;
	
	}
	
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
}
