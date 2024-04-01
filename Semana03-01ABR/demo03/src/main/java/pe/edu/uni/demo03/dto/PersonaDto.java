package pe.edu.uni.demo03.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class PersonaDto {
	
	private String nombre;
	private String correo;
	private int edad;
	
	
}
