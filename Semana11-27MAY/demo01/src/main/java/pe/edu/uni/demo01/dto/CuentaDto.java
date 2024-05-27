package pe.edu.uni.demo01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CuentaDto {

	private String codigo;
	private String moneda;
	private String sucursal;
	private String empleado;
	private String cliente;
	private Double saldo;
	private String fecha;
	private String estado;
	private Integer contador;
	private String clave;

}
