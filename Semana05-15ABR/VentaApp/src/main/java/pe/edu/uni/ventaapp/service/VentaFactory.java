package pe.edu.uni.ventaapp.service;

public class VentaFactory {

	public static final String FACTURA = "FACTURA";
	public static final String BOLETA = "BOLETA";

	private VentaFactory() {
	}

	public static VentaAbstract get(String tipo) {
		// Variables
		VentaAbstract bean;
		// Proceso
		bean = null;
		switch (tipo) {
			case FACTURA -> bean = new FacturaService();
			case BOLETA -> bean = new BoletaService();
		}
		// Reporte
		return bean;
	}

}

