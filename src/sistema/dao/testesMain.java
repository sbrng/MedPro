package sistema.dao;

import java.util.Calendar;
import java.util.List;

import sistema.beans.Consulta;

public class testesMain {
	public static void main(String[] args) {

		String text = "15:45, 22/05/2020";

		String[] timeData = text.split(",\\s");
		String[] horaMin = timeData[0].split(":");
		String[] datas = timeData[1].split("/");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(datas[2]), Integer.parseInt(datas[1]), Integer.parseInt(datas[0]),
				Integer.parseInt(horaMin[0]), Integer.parseInt(horaMin[1]));

		System.out.println(timeData[1]);
		Calendar temp = Calendar.getInstance();
		Consulta con = new Consulta("med1", "98098", temp, "Hospital_Português");
		//Consulta con = new Consulta();
		con.setDataHora(text);
		
		ConsultaDAO conDAO = new ConsultaDAO();
		//conDAO.create(con);

		//List<Consulta> lista = conDAO.read();
		con.setSintomas("febre, dor de cabeça, vômito");
		con.setId(4);
		//conDAO.update(con);
		for(String a : con.getSintomas()) {
			System.out.println(a);
		}
		
		//conDAO.consultasPorPaciente("98098");
		
		System.out.println(con.getSintomasString());
		
		//System.out.println(conDAO.consultasPorPaciente("98098"));
		// conDAO.delete(lista.get(2));
		
	}
}
