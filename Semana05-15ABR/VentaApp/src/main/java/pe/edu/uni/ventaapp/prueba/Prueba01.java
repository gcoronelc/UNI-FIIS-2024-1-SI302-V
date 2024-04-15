package pe.edu.uni.ventaapp.prueba;

import pe.edu.uni.ventaapp.dto.ItemDTO;
import pe.edu.uni.ventaapp.service.BoletaService;
import pe.edu.uni.ventaapp.service.VentaAbstract;


public class Prueba01 {

	public static void main(String[] args) {
		
		//Datos
		double total = 154.20;
		//Proceso
		VentaAbstract service = new BoletaService();
		ItemDTO[] repo = service.procesar(total);
		//Reporte
		for (ItemDTO dto:repo){
			System.out.println(dto);
		}
	}
}
