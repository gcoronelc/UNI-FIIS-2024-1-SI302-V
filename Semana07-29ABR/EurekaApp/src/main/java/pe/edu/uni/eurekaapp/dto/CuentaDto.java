package pe.edu.uni.eurekaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class CuentaDto {
	
	private String codigo;
	private String cuenta;
	private String moneda;
	private String cliente;
	private double saldo;
	private String estado;

}
