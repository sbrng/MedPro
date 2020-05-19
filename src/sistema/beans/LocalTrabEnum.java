package sistema.beans;

import java.util.HashMap;
import java.util.Map;

public enum LocalTrabEnum {
	Hospital_Santa_Helena, 
	Hospital_Português,
	Hospital_Esperança,
	HOPE,
	Hospital_Memorial_São_José, 
	Hospital_Santa_Joana,
	IMIP, 
	Hospital_Agamenon_Magalhães, 
	Hospital_Barão_de_Lucena, 
	Hospital_Colônia_Professor_Alcides_Codeceira, 
	Hospital_Correia_Picanço, 
	Hospital_da_Restauração, 
	Hospital_Geral_da_Mirueira, 
	Hospital_Geral_de_Areias, 
	Hospital_Getúlio_Vargas, 
	Hospital_Jaboatão_Prazeres,
	Hospital_Miguel_Arraes_de_Alencar,
	Hospital_Pelópidas_Silveira,
	Hospital_Dom_Hélder_Câmara,
	Hospital_Otávio_de_Freitas,
	Hospital_Psiquiátrico_Ulysses_Pernambucano,
	Hospital_São_Lucas,
	OUTRO;
	
	private Map<String, String> map = new HashMap<String, String>();

	public Map<String, String> getMap() {
		return map;
	}
	
	public void setMap() {
		
		for(LocalTrabEnum a : LocalTrabEnum.values()) {
			
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
