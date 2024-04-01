package pe.edu.uni.demo03.prueba;

import pe.edu.uni.demo03.dto.MateDto;
import pe.edu.uni.demo03.service.MateService;

public class Prueba06 {
	
	public static void main(String[] args) {
		// Datos
		MateDto dto = new MateDto();
		dto.setNum1(60);
		dto.setNum2(35);
		// Proceso
		MateService service = new MateService();
		dto = service.calcular(dto);
		// Reporte
		System.out.println("Suma: " + dto.getSuma());
		System.out.println("Resta: " + dto.getResta());
	}
	
}
