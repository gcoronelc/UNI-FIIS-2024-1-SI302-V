package pe.edu.uni.demo01.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.uni.demo01.dto.ClienteDto;
import pe.edu.uni.demo01.service.ClienteService;

@RequestMapping("/clientes")
@RestController
public class ClienteRest {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Map<String,Object>> getClientes(){
		return clienteService.obtenerClientes1();
	}
	
	@GetMapping("/v2")
	public List<ClienteDto> getClientes2(){
		return clienteService.obtenerClientes2();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<ClienteDto> getCliente(@PathVariable String codigo){
		ClienteDto dto = clienteService.obtenerCliente(codigo);
		if(dto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(dto);
	}
	
}
