package pe.edu.uni.ventaapp.service;

import pe.edu.uni.ventaapp.dto.ItemDTO;

public abstract class VentaAbstract {

	public final double IGV = 0.18;
	public final double SERVICIO = 0.10;

	public abstract ItemDTO[] procesar(double total);

}
