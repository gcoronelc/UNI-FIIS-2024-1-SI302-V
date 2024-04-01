package pe.edu.uni.pagoapp.prueba;

import pe.edu.uni.pagoapp.dto.PagoDTO;
import pe.edu.uni.pagoapp.service.PagoService;

public class Prueba02 {
	public static void main(String[] args) {
		//datos
		PagoDTO dto = new PagoDTO();
		dto.setDias(6);
		dto.setHorasDia(8);
		dto.setPagoHora(10);
		
		//procesos
		PagoService service = new PagoService();
		dto = service.procesar(dto);
		//reporte
		System.out.println("Ingreso: " + dto.getIngreso());
		System.out.println("Renta: " + dto.getRenta());
		System.out.println("Neto: " + dto.getNeto());
	}
}
