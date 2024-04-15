package pe.edu.uni.ventaapp.service;

import pe.edu.uni.ventaapp.dto.ItemDTO;


public class FacturaService extends VentaAbstract{

	@Override
	public ItemDTO[] procesar(double total) {
		// Variables
		ItemDTO dto[];
		double consumo, impuesto;
		double servicio, totalGeneral;
		// Proceso
		consumo = total / (1 + IGV);
		impuesto = total - consumo;
		servicio = total * SERVICIO;
		totalGeneral = total + servicio;
		// Reporte
		dto = new ItemDTO[]{
			new ItemDTO("Consumo",consumo),
			new ItemDTO("Impuesto",impuesto),
			new ItemDTO("Total",total),
			new ItemDTO("Servicio",servicio),
			new ItemDTO("Total general",totalGeneral),
		};
		return dto;
	}

}
