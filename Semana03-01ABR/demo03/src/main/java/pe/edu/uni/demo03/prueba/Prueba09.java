package pe.edu.uni.demo03.prueba;

import java.util.List;
import pe.edu.uni.demo03.dto.PersonaDto;
import pe.edu.uni.demo03.service.PersonaService;

public class Prueba09 {
	
	public static void main(String[] args) {
		PersonaService service = new PersonaService();
		
		// Nueva persona
		service.agregar(new PersonaDto("Diego", "diego@gmail.com", 19));
		
		// Reporte
		PersonaDto[] lista = service.listado();
		for (Object o : lista) {
			System.out.println(o);
		}
		
	}
}
