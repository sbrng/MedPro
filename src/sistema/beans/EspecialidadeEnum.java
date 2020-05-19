package sistema.beans;

import java.util.HashMap;
import java.util.Map;

public enum EspecialidadeEnum {
	Acupuntura , 
	Alergia_e_Imunologia, 
	Anestesiologia, 
	Angiologia, 
	Cancerologia, 
	Cardiologia, 
	Cirurgia_Cardiovascular, 
	Cirurgia_da_Mão, 
	Cirurgia_de_Cabeça_e_Pescoço, 
	Cirurgia_do_Aparelho_Digestivo, 
	Cirurgia_Geral,
	Cirurgia_Pediátrica, 
	Cirurgia_Plástica, 
	Cirurgia_Torácica, 
	Cirurgia_Vascular, 
	Clínica_Médica, 
	Coloproctologia,
	Dermatologia, 
	Endocrinologia_e_Metabologia, 
	Endoscopia, 
	Gastroenterologia, 
	Genética_Médica, 
	Geriatria,
	Ginecologia_e_Obstetrícia, 
	Hematologia_e_Hemoterapia, 
	Homeopatia, 
	Infectologia, 
	Mastologia,
	Medicina_de_Família_e_Comunidade, 
	Medicina_do_Trabalho, 
	Medicina_de_Tráfego, 
	Medicina_Esportiva,
	Medicina_Física_e_Reabilitação, 
	Medicina_Intensiva, 
	Medicina_Legal_e_Perícia_Médica, 
	Medicina_Nuclear,
	Medicina_Preventiva_e_Social, 
	Nefrologia, 
	Neurocirurgia, 
	Neurologia, 
	Nutrologia, 
	Oftalmologia,
	Ortopedia_e_Traumatologia, 
	Otorrinolaringologia, 
	Patologia, 
	Medicina_Laboratorial, 
	Pediatria, 
	Pneumologia, 
	Psiquiatria, 
	Radiologia, 
	Radioterapia, 
	Reumatologia, 
	Urologia,
	OUTRA;
	
	private Map<String, String> map = new HashMap<String, String>();

	public Map<String, String> getMap() {
		return map;
	}
	
	public void setMap() {
		
		for(EspecialidadeEnum a : EspecialidadeEnum.values()) {
			
			String value = a.toString();
			
			String[] partes = value.split("_");
			
			String key = "";
			
			for(int i = 0; i<partes.length; i++) {
				if(i == partes.length-1) {
					key = key + partes[i];
				}else {
					key = key + partes[i] + " ";
				}
			}
			this.map.put(key, value);
		}
	}
}
