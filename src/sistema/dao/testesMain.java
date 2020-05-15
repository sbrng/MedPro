package sistema.dao;

import java.util.Calendar;
import java.util.List;

import sistema.beans.Consulta;

public class testesMain {
	public static void main(String[] args) {
		
		String text = "15:45, 16/05/2020";
		
		String[] timeData = text.split(",\\s");
        String[] horaMin = timeData[0].split(":");
        String[] datas = timeData[1].split("/");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(datas[2]),Integer.parseInt(datas[1]),Integer.parseInt(datas[0]), Integer.parseInt(horaMin[0]), Integer.parseInt(horaMin[1]));
        
		System.out.println(timeData[1]);
		
		Consulta con = new Consulta("78789", "98098", calendar, "H. Português", "" );
		
		ConsultaDAO conDAO = new ConsultaDAO();
		//conDAO.create(con);
		
		List<Consulta> lista = conDAO.read();
		System.out.println(lista.get(0));
		
		//conDAO.delete(lista.get(2));
		
	}
}
