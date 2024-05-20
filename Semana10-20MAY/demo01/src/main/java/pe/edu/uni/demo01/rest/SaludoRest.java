package pe.edu.uni.demo01.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/saludo")
@RestController
public class SaludoRest {

	
	@GetMapping
	public String saludo() {
		return "Hola todos";
	}
	
	@GetMapping("/mensaje")
	public String saludo(String nombre) {
		return "Hola " + nombre + ".";
	}

}
