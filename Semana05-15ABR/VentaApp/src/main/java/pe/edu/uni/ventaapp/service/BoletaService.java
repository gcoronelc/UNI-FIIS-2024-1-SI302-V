package pe.edu.uni.ventaapp.service;

import pe.edu.uni.ventaapp.dto.ItemDTO;


public class BoletaService extends VentaAbstract{

	@Override
	public ItemDTO[] procesar(double total) {
		// Variables
		ItemDTO dto[];
		double servicio, totalGeneral;
		// Proceso
		servicio = total * SERVICIO;
		totalGeneral = total + servicio;
		// Reporte
		dto = new ItemDTO[]{
			new ItemDTO("Total",total),
			new ItemDTO("Servicio",servicio),
			new ItemDTO("Total general",totalGeneral),
		};
		return dto;
	}

}
