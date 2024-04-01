package pe.edu.uni.pagoapp.dto;

import lombok.Data;

@Data
public class PagoDTO {
	// Datos
	private int horasDia;
	private int dias;
	private double pagoHora;
	// Salida
	private double ingreso;
	private double renta;
	private double neto;

	public PagoDTO() {
	}

	public PagoDTO(int horasDia, int dias, double pagoHora) {
		this.horasDia = horasDia;
		this.dias = dias;
		this.pagoHora = pagoHora;
	}
		
}
