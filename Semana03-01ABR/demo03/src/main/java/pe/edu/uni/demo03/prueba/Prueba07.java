package pe.edu.uni.demo03.prueba;

import pe.edu.uni.demo03.service.MateService;

public class Prueba07 {
	
	public static void main(String[] args) {
		// Datos
		int n1 = 18;
		double n2 = 20;
		// Proceso
		MateService service = new MateService();
		double pr = service.promedio(n1, n2);
		// Reporte
		System.out.println("Promedio : " + pr);
		
	}
	
}
