package pe.edu.uni.demo03.service;

import pe.edu.uni.demo03.dto.MateDto;

public class MateService {
	
	public MateDto calcular(MateDto dto){
		// Variables
		int suma;
		int resta;
		// Proceso
		suma = dto.getNum1() + dto.getNum2();
		resta = dto.getNum1() - dto.getNum2();
		// Reporte
		dto.setSuma(suma);
		dto.setResta(resta);
		return dto;
	}
	
	public static int promedio(int n1, int n2){
		System.out.println("int int");
		return(n1 + n2) / 2;
	}
	
	public double promedio(int n1, double n2){
		System.out.println("int double");
		return(n1 + n2) / 2;
	}
	
	public double promedio(double n1, double n2){
		System.out.println("double double");
		return(n1 + n2) / 2;
	}
	
	public int promedio(int n1, int n2, int n3){
		return(n1 + n2 + n3) / 3;
	}
	
}
