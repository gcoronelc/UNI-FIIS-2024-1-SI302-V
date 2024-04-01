package pe.edu.uni.pagoapp.service;

import pe.edu.uni.pagoapp.dto.PagoDTO;

public class PagoService {
	public PagoDTO procesar(PagoDTO dto){
		//Variables
		double ingreso;
		double renta;
		double neto;
		//Proceso
		ingreso = dto.getDias() * dto.getHorasDia() * dto.getPagoHora();
		if(ingreso >1500.0){
			renta = ingreso * 0.08;
		}
		else{
			renta = 0;
		}
		neto = ingreso - renta;
		//Reporte
		dto.setIngreso(ingreso);
		dto.setRenta(renta);
		dto.setNeto(neto);
		return dto;
	}
	
}
