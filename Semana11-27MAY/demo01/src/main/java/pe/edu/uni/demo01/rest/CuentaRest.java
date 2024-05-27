package pe.edu.uni.demo01.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.uni.demo01.dto.CuentaDto;
import pe.edu.uni.demo01.service.CuentaService;

@RequestMapping("/cuentas")
@RestController
public class CuentaRest {

	@Autowired
	private CuentaService cuentaService;
	
	@PostMapping("/crear")
	public ResponseEntity<?> crearCuenta(@RequestBody CuentaDto bean){
		try {
			bean = cuentaService.registrarCuenta(bean);
			return ResponseEntity.ok().body(bean);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error en el proceso",HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
