package pe.edu.uni.demo03.prueba;

import pe.edu.uni.demo03.service.MateService;

public class Prueba08 {
	
	public static void main(String[] args) {
		// Datos
		int n1 = 18;
		int n2 = 20;
		// Proceso
		double pr = MateService.promedio(n1, n2);
		// Reporte	
		System.out.println("Promedio : " + pr);
		System.out.println("Mayor de 12 y 78: " + Math.max(12, 78));
		
	}
	
}
